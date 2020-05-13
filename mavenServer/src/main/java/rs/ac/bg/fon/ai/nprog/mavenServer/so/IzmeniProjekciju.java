/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.DomainObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;

import java.util.List;

/**
 *
 * @author Ivona
 * 
 * @version 1.0
 * 
 *          Klasa IzmeniProjekciju predstavlja sistemsku operaciju koja menja
 *          podatke u bazi u projekciji. Nasledjuje AbstractSystemOperation.
 */
public class IzmeniProjekciju extends AbstractSystemOperation {
	/**
	 * objekat koji zelimo da izmenimo
	 */
	Showtime showtime;

	/**
	 * Parametrizovani konstruktor metode izmeni projekciju.
	 * 
	 * @param object koji zelimo da izmenimo
	 * @throws Exception ako primljeni objekat nije instanca klase Showtime
	 */
	public IzmeniProjekciju(Object object) throws Exception {
		validate(object);
		this.showtime = (Showtime) object;
	}

	/**
	 * Metoda kojom se azurira projekciju u bazi.
	 * 
	 * @throws Exception ako dodje do greske prilikom azuriranja projekcije.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		dbb.updateDomainObject(showtime);
	}

	/**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase Showtime.
	 * 
	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
	 *               Showtime.
	 * @throws ValidationException ako objekat nije instanca klase Showtime.
	 * 
	 */
	protected void validate(Object object) throws Exception {
		if (!(object instanceof Showtime)) {
			throw new Exception("Objekat nije instanca klase Projekcija!");
		}
	}
}
