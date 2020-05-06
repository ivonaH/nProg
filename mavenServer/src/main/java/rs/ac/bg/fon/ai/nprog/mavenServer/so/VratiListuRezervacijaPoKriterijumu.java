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
*          Klasa VratiListuRezervacija predstavlja sistemsku operaciju koja vraca listu rezervacija iz baze po odredjenom kritrerijumu.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuRezervacijaPoKriterijumu extends AbstractSystemOperation {
	/**
	 * Lista rezervacija.
	 */
    private List<Reservation> reservations;

    /**
	 * Metoda koja vraca listu rezervacija iz baze po odredjenom kritrerijumu.
	 * 
	 * @param object  Objekat koji zelimo da pronadjemo.
  	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo listu rezervacija.
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo listu rezervacija.
	 * @throws Exception ako dodje do greske prilikom trazenja rezervacija.
	 */
    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        reservations=(List<Reservation>)(Object) dbb.getAllDomainObjectsWithWhere(new Reservation(), columns, values);
    }

    /**
     * Metoda koja vrsi validaciju.
     */
    @Override
    protected void validate(Object object) throws Exception {
    }

    /**
     * Metoda koja vraca listu rezervacija.
     * @return lista rezervacija
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

}
