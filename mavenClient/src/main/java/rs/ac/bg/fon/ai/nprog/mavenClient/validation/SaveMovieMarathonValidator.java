package rs.ac.bg.fon.ai.nprog.mavenClient.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;

public class SaveMovieMarathonValidator {

    public static void validateShowtimes(List<Showtime> showtimes) throws ValidationException {
        if (showtimes == null || showtimes.size() < 2) {
            throw new ValidationException("Movie Marathon must contain at least 2 showtimes");
        }
        validateShowtimesDates(showtimes);
        validateShowtimesTimes(showtimes);
        validateMoviesAtShowtimes(showtimes);

    }

    private static void validateShowtimesDates(List<Showtime> showtimes) throws ValidationException {
        for (int i = 0; i < showtimes.size() - 1; i++) {
            for (int j = i + 1; j < showtimes.size(); j++) {
                if (!showtimes.get(i).getDate().equals(showtimes.get(j).getDate())) {
                    System.out.println(showtimes.get(i).getDate());
                    System.out.println(showtimes.get(j).getDate());
                    throw new ValidationException("Showtimes at Movie Marathon must have same Date!");
                }
            }
        }
    }

    private static void validateShowtimesTimes(List<Showtime> showtimes) throws ValidationException {
        for (int i = 0; i < showtimes.size() - 1; i++) {
            for (int j = i + 1; j < showtimes.size(); j++) {
                Date startOfMovie1 = showtimes.get(i).getTime();
                Date startOfMovie2 = showtimes.get(j).getTime();
                SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
                try {
                    Date endOfMovie1 =sdf.parse( getEndOfMovie(startOfMovie1, showtimes.get(i).getMovie().getDurationInMinutes()));
                    Date endOfMovie2 = sdf.parse(getEndOfMovie(startOfMovie2, showtimes.get(j).getMovie().getDurationInMinutes()));
                    if (endOfMovie1.after(startOfMovie2) && startOfMovie1.before(startOfMovie2)) {
                        throw new ValidationException("Showtime time overlap!");
                    } else if (endOfMovie2.after(startOfMovie1) && startOfMovie2.before(startOfMovie1)) {
                        throw new ValidationException("Showtime time overlap!");
                    } else if (startOfMovie1.equals(startOfMovie2)) {
                        throw new ValidationException("Showtimes can't start at same time");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(SaveMovieMarathonValidator.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(calendar.getTime(Calendar.HOUR_OF_DAY));

            }
        }
    }

    private static void validateMoviesAtShowtimes(List<Showtime> showtimes) throws ValidationException {
        for (int i = 0; i < showtimes.size() - 1; i++) {
            for (int j = i + 1; j < showtimes.size(); j++) {
                System.out.println("Movie1: " + showtimes.get(i).getMovie() + " Movie2: " + showtimes.get(j).getMovie());
                if (showtimes.get(i).getMovie().equals(showtimes.get(j).getMovie())) {
                    throw new ValidationException("Movie Marathon can't have same Movies");
                }
            }
        }
    }

    private static Date addMinutesToDate(int minutes, Date beforeTime) {
        final long ONE_MINUTE_IN_MILLIS = 60000;

        long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
        System.out.println("AFTER ADING:" + afterAddingMins);
        return afterAddingMins;
    }

    private static String getEndOfMovie(Date startOfMovie, int durationInMinutes) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startOfMovie);
        calendar.add(Calendar.MINUTE, durationInMinutes);

        return calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
    }

}
