package rs.ac.bg.fon.ai.nprog.mavenServer.validator.showtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DBBroker;

/**
 *
 * @author Ivona
 */
public class SaveShowtimeValidator {

    public static void validateShowtime(Showtime newShowtime) throws ValidationException, Exception {
        DBBroker dbb = new DBBroker();
        List<String> columns = new ArrayList<>();
        columns.add("t.hallId");
        columns.add("date");
        List<String> values = new ArrayList<>();
        values.add(newShowtime.getHall().getHallId() + "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        values.add(sdf.format(newShowtime.getDate()));

        List<Showtime> showtimes = (List<Showtime>) (Object) dbb.getAllDomainObjectsWithWhere(new Showtime(), columns, values);
        if (!validateShowtimeTimes(showtimes, newShowtime)) {
            throw new ValidationException("There is already showtime at that time");
        }

    }

    public static boolean validateShowtimeTimes(List<Showtime> showtimes, Showtime newShowtime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            Date startOfMovie2 = newShowtime.getTime();
            Date endOfMovie2 = sdf.parse(getEndOfMovie(startOfMovie2, newShowtime.getMovie().getDurationInMinutes()));
            for (int i = 0; i < showtimes.size(); i++) {

                if (showtimes.get(i).getShowtimeId()==newShowtime.getShowtimeId()) {//when updating skip current
                    continue;
                }
                Date startOfMovie1 = showtimes.get(i).getTime();
                Date endOfMovie1 = sdf.parse(getEndOfMovie(startOfMovie1, showtimes.get(i).getMovie().getDurationInMinutes()));
                if (startOfMovie1 == startOfMovie2) {
                    return false;
                } else if (endOfMovie1.after(startOfMovie2) && startOfMovie1.before(startOfMovie2)) {
                    return false;
                } else if (endOfMovie2.after(startOfMovie1) && startOfMovie2.before(startOfMovie1)) {
                    return false;
                } else if (startOfMovie1.equals(startOfMovie2)) {
                    return false;
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(SaveShowtimeValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    private static Date addMinutesToDate(int minutes, Date beforeTime) {
        final long ONE_MINUTE_IN_MILLIS = 60000;

        long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
        return afterAddingMins;
    }

    private static String getEndOfMovie(Date startOfMovie, int durationInMinutes) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startOfMovie);
        calendar.add(Calendar.MINUTE, durationInMinutes);
   
        return calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
    }

}

