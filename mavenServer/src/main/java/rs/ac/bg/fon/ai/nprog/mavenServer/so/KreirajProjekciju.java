/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import rs.ac.bg.fon.ai.nprog.mavenServer.validator.showtime.SaveShowtimeValidator;

import java.util.List;

/**
 *
 * @author Ivona
 * 
 * @version 1.0
 * 
 *          Klasa KreirajProjekciju predstavlja sistemsku operaciju koja cuva
 *          projekcija u bazi. Nasledjuje AbstractSystemOperation.
 */
public class KreirajProjekciju extends AbstractSystemOperation {

	/**
	 * objekat koji zelimo da sacuvamo.
	 */
	Showtime showtime;

	/**
	 * Parametrizovani konstruktor metode kreiraj projekciju.
	 * 
	 * @param object koji zelimo da sacuvamo
	 * @throws Exception ako primljeni objekat nije instanca klase Showtime ili ako
	 *                   sala nije dostupna u tom terminu.
	 */
	public KreirajProjekciju(Object object) throws Exception {
		validate(object);
		this.showtime = (Showtime) object;
		validateShowtimeDetails();

	}

	/**
	 * Metoda koja cuva projekciju u bazi.
	 * 
	 * @throws Exception ako dodje do greske prilikom cuvanja projekcije u bazi.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		showtime.setShowtimeId(dbb.generateId(showtime));
		dbb.saveDomainObject(showtime);
	}

	/**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase Showtime.
	 * 
	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
	 *               Showtime.
	 * @throws Exception ako objekat nije instanca klase Showtime.
	 * 
	 */
	protected void validate(Object object) throws Exception {
		if (!(object instanceof Showtime)) {
			throw new Exception("Objekat nije instanca klase Projekcija!");
		}
	}

	/**
	 * Metoda proverava da li je sala slobodna u tom terminu.
	 * 
	 * @throws ValidationException ako sala nije slobodna u tom terminu.
	 */

	protected void validateShowtimeDetails() throws ValidationException {
		try {
			SaveShowtimeValidator.validateShowtime(showtime);
		} catch (Exception ex) {
			throw new ValidationException("There is already showtime at that time");
		}
	}
}
