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
	 * objekat koji zelimo da obrisemo.
	 */
	Reservation reservation;

	/**
	 * Parametrizovani konstruktor metode obrisi rezervaciju.
	 * 
	 * @param object koji zelimo da obrisemo
	 * @throws Exception ako primljeni objekat nije instanca klase Reservation
	 */
	public ObrisiRezervaciju(Object object) throws Exception {
		validate(object);
		this.reservation = (Reservation) object;
	}

	/**
	 * Metoda koja brise rezervacija iz baze.
	 * 
	 * @throws Exception ako dodje do greske prilikom brisanja rezervacije iz baze.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		dbb.deleteDomainObject(reservation);
	}

	/**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase Reservation.
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
