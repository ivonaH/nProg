/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;

import java.util.ArrayList;
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
	 * Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo
	 * listu maratona.
	 */
	List<String> columns;
	/**
	 * Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo
	 * listu maratona.
	 */
	List<String> values;
	
	/**
	 * Lista rezervacija.
	 */
    private List<Reservation> reservations;


/**
 * Parametrizovani konstruktor metode koja vraca listu rezervacija po odredjenom kriterijumu.
 * 
 * @param columns Lista u kojoj su zadati nazivi kolona po kojima trazimo listu rezervacija.
 * @param values  Lista u kojoj su zadate vrednosti kolona po kojima trazimo rezervacije.
 * @throws Exception
 */
	public VratiListuRezervacijaPoKriterijumu(List<String> columns, List<String> values) throws Exception {
		this.columns = columns;
		this.values = values;
	}

	
    /**
	 * Metoda koja vraca listu rezervacija iz baze po odredjenom kritrerijumu.
	 * 
	 * @throws Exception ako dodje do greske prilikom trazenja rezervacija.
	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        reservations=(List<Reservation>)(Object) dbb.getAllDomainObjectsWithWhere(new Reservation(), columns, values);
    }

    /**
     * Metoda koja vraca listu rezervacija.
     * @return lista rezervacija
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

}
