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
	 * @param object  Objekat koji zelimo da pronadjemo.
	 * @param columns null
	 * @param values null
	 * @throws Exception ako dodje do greske prilikom trazenja rezervacija.
	 */
    @Override
    protected void executeSpecificOperation(DomainObject object,List<String> columns, List<String> values) throws Exception {
        reservations = (List< Reservation>) (Object) dbb.getAllDomainObjectsWithJoin(new Reservation());
    }

    /**
     * Metoda koja vrsi validaciju.
     */
    @Override
    protected void validate(DomainObject object) throws Exception {
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

}
