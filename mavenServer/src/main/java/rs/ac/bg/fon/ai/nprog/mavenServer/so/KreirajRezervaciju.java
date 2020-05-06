/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;

import java.util.List;

/**
*
* @author Ivona
* 
* @version 1.0
* 
*          Klasa KreirajRezervaciju predstavlja sistemsku operaciju koja cuva rezervacija u bazi.
*          Nasledjuje AbstractSystemOperation.
*/
public class KreirajRezervaciju extends AbstractSystemOperation {
	/**
	 * objekat koji zelimo da sacuvamo.
	 */
	Reservation reservation;

	/**
	 * Parametrizovani konstruktor metode kreiraj rezervaciju.
	 * 
	 * @param object koji zelimo da sacuvamo
	 * @throws Exception ako primljeni objekat nije instanca klase Reservation
	 */
	public KreirajRezervaciju(Object object) throws Exception {
		validate(object);
		this.reservation = (Reservation) object;
	}
	
	/**
	 * Metoda koja cuva rezervaciju u bazi.
	 * 
	 *
	 * @throws Exception ako dodje do greske prilikom cuvanja rezervacije u bazi.
	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        reservation.setReservationId(dbb.generateId(reservation));
        dbb.saveDomainObject(reservation);
    }

    /**
 	 * Metoda koja vrsi validaciju da li je objekat instanca klase
 	 * Reservation.
 	 * 
 	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
 	 *               Reservation.
 	 * @throws Exception ako objekat nije instanca klase Reservation.
 	 * 
 	 */
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Reservation)) {
            throw new Exception("Objekat nije instanca klase Rezervacija!");
        }
    }
}
