/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
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
	 * Metoda koja cuva film u bazi.
	 * 
	 * 
	 * @param object  Objekat koji zelimo da sacuvamo u bazi.
	 * @param columns null
	 * @param values  null
	 * @throws Exception ako dodje do greske prilikom cuvanja filma u bazi.
	 */
    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        Movie movie = (Movie) object;
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
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Movie)) {
            throw new Exception("Objekat nije instanca klase Film!");
        }
    }
    
}
