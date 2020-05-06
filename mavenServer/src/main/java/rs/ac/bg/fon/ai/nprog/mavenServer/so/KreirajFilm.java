/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
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
*          Klasa KreirajFilm predstavlja sistemsku operaciju koja cuva film u bazi.
*          Nasledjuje AbstractSystemOperation.
*/
public class KreirajFilm extends AbstractSystemOperation {
	/**
	 * objekat koji zelimo da sacuvamo.
	 */
	Movie movie;

	/**
	 * Parametrizovani konstruktor metode kreiraj film.
	 * 
	 * @param object koji zelimo da sacuvamo
	 * @throws Exception ako primljeni objekat nije instanca klase Movie
	 */
	public KreirajFilm(Object object) throws Exception {
		validate(object);
		this.movie = (Movie) object;
	}
	/**
	 * Metoda koja cuva film u bazi.
	 * 
	 * @throws Exception ako dodje do greske prilikom cuvanja filma u bazi.
	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        movie.setMovieId(dbb.generateId(movie));
        dbb.saveDomainObject(movie);
    }
    
    /**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase
	 * Movie.
	 * 
	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
	 *               Movie.
	 * @throws Exception ako objekat nije instanca klase Movie.
	 * 
	 */
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Movie)) {
            throw new Exception("Objekat nije instanca klase Film!");
        }
    }
    
}
