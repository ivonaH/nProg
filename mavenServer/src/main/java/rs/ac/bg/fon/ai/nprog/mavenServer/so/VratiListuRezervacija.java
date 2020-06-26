/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import java.util.List;

/**
*
* @author Ivona
* 
* @version 1.0
* 
*          Klasa VratiListuRezervacija predstavlja sistemsku operaciju koja vraca listu rezervacija iz baze.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuRezervacija extends AbstractSystemOperation {
/**
 * Lista rezervacija.
 */
    List<Reservation> reservations;

    /**
	 * Metoda koja vraca listu rezervacija iz baze.
	 * 
	 * @throws Exception ako dodje do greske prilikom trazenja rezervacija.
	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        reservations = (List< Reservation>) (Object) dbb.getAllDomainObjects(new Reservation());
    }

    
/**
 * Metoda koja vraca listu rezervacija.
 * @return lista rezervacija
 */
    public List<Reservation> getReservations() {
        return reservations;
    }

}
