package rs.ac.bg.fon.ai.nprog.mavenClient.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;


public class ShowtimeValidation {

    public static void validateShowtimeDate(Showtime showtime) throws ValidationException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (sdf.format(showtime.getDate()).equals(sdf.format(calendar.getTime()))) {
            sdf = new SimpleDateFormat("HH:mm:ss");
            try {
                Date shTime = showtime.getTime();
                SimpleDateFormat formatMinutes = new SimpleDateFormat("mm");
                String getMinutes = formatMinutes.format(new Date());
                SimpleDateFormat formatHours = new SimpleDateFormat("HH");
                String getHours = formatHours.format(new Date());
                String hourNow = getHours + ":" + getMinutes + ":00";
                if (shTime.before(sdf.parse(hourNow))) {
                    throw new ValidationException("Datum i vreme projekcije su u proslosti.");
                }

            } catch (ParseException ex) {
                return;
            }

        }

    }
}
