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
 *          Klasa ObrisiRezervaciju predstavlja sistemsku operaciju kojom se
 *          brise rezervacija iz baze. Nasledjuje AbstractSystemOperation.
 */
public class ObrisiRezervaciju extends AbstractSystemOperation {

	/**
	 * Metoda koja brise rezervacija iz baze.
	 * 
	 * 
	 * @param object  Objekat koji zelimo da obrisemo iz baze.
	 * @param columns null
	 * @param values  null
	 * @throws Exception ako dodje do greske prilikom brisanja rezervacije iz baze.
	 */
	@Override
	protected void executeSpecificOperation(DomainObject object, List<String> columns, List<String> values)
			throws Exception {
		dbb.deleteDomainObject(object);
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
	@Override
	protected void validate(DomainObject object) throws Exception {
		if (!(object instanceof Reservation)) {
			throw new Exception("Objekat nije instanca klase Rezervacija!");
		}
	}

}
