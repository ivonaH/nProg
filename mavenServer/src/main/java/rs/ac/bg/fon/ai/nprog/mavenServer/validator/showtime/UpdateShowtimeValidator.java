package rs.ac.bg.fon.ai.nprog.mavenServer.validator.showtime;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DBBroker;

/**
*
* @author Ivona
*/
public class UpdateShowtimeValidator {

   public static void checkNewHallCapacity(Showtime showtime) throws Exception {
       DBBroker dbb = new DBBroker();
       int showtimeId = showtime.getShowtimeId();
       int numberOfReservations = dbb.countDomainObjectsWithWhere(new Reservation(), "showtimeId", showtimeId);
       int hallCapacity = showtime.getHall().getCapacity();
            System.out.println("USAO U PROVERU I IZBROJAO JE REZERVACIJA: "+numberOfReservations+" hallCAPACITY:"+showtime.getHall().getName()+" "+hallCapacity);
       if(numberOfReservations>hallCapacity) throw new ValidationException();

   }
}
