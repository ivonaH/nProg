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
	 * Metoda kojom se azurira projekciju u bazi.
	 * 
	 * 
	 * @param object  Objekat koji zelimo da izmenimo.
	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona koje cemo azurirati.
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona na koje cemo postavljati zadate kolone.
	 * @throws Exception ako dodje do greske prilikom azuriranja projekcije.
	 */
	@Override
	protected void executeSpecificOperation(DomainObject object, List<String> columns, List<String> values)
			throws Exception {
		dbb.updateDomainObject(object);
	}

	/**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase
	 * Showtime.
	 * 
	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
	 *               Showtime.
	 * @throws Exception ako objekat nije instanca klase Showtime.
	 * 
	 */
	@Override
	protected void validate(DomainObject object) throws Exception {
		if (!(object instanceof Showtime)) {
			throw new Exception("Objekat nije instanca klase Projekcija!");
		}
	}
}
