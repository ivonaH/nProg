/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.DomainObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivona
 * 
 * @version 1.0
 * 
 *          Klasa KreirajFilmskiMaraton predstavlja sistemsku operaciju koja
 *          cuva filmski maraton u bazi. Nasledjuje AbstractSystemOperation.
 */
public class KreirajFilmskiMaraton extends AbstractSystemOperation {
	/**
	 * objekat koji primamo kroz konstruktor koji sadrzi filmski maraton i
	 * projekcije
	 */
	Object object;
	/**
	 * FilmskiMaraton koji zelimo da sacuvamo.
	 */
	MovieMarathon mm;

	/**
	 * Parametrizovani konstruktor metode kreiraj filmski maraton.
	 * 
	 * @param object koji zelimo da sacuvamo
	 * @throws Exception ako primljeni objekat nije instanca klase MovieMarathon
	 */
	public KreirajFilmskiMaraton(Object object) throws Exception {
		validate(((ArrayList<Object>) object).get(0));
		this.object=object;
		this.mm = (MovieMarathon) ((ArrayList<Object>) object).get(0);
	}

	/**
	 * Metoda koja cuva filmski maraton u bazi.
	 * 
	 * @throws Exception ako dodje do greske prilikom cuvanja filmskog maratona u
	 *                   bazi.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		ArrayList<DomainObject> showtimes = (ArrayList<DomainObject>) ((ArrayList<Object>) object).get(1);
		mm.setMarathonId(dbb.generateId(mm));
		dbb.saveDomainObject(mm);
		dbb.updateDomainObjects(showtimes, "movieMarathonId", mm.getMarathonId() + "");
	}

	/**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase MovieMarathon.
	 * 
	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
	 *               MovieMarathon.
	 * @throws Exception ako objekat nije instanca klase MovieMarathon.
	 * 
	 */
	protected void validate(Object object) throws Exception {
		if (!(object instanceof MovieMarathon)) {
			throw new Exception("Objekat nije instanca klase FilmskiMaraton!");
		}
	}
}
