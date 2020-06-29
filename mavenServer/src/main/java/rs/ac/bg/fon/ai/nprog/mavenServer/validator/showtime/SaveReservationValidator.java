package rs.ac.bg.fon.ai.nprog.mavenServer.validator.showtime;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DBBroker;

/**
*
* @author Ivona
*/
public class SaveReservationValidator {
   
      public static void checkCapacity(Reservation reservation) throws ValidationException, Exception {
          int showtimeId=reservation.getShowtime().getShowtimeId();
          int hallCapacity=reservation.getShowtime().getHall().getCapacity();
          DBBroker dbb=new DBBroker();
          int numberOfReservations=dbb.countDomainObjects(new Reservation(), "showtimeId",showtimeId);
       System.out.println("USAO U PROVERU I IZBROJAO JE REZERVACIJA: "+numberOfReservations+" hallCAPACITY: "+hallCapacity);
       if(numberOfReservations>=hallCapacity) throw new ValidationException("Showtime capacity is full.");
   }
   
}
