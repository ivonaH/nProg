/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenServer.database.DBBroker;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;
import java.util.List;

/**
*
* @author Ivona
* 
* @version 1.0
* 
*          Klasa VratiListuFilmova predstavlja sistemsku operaciju koja vraca listu filmova iz baze.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuFilmova extends AbstractSystemOperation {
/**
 * Lista filmova.
 */
    List<Movie> movies;
    /**
	 * Metoda koja vraca listu filmova iz baze.
	 * 
	 * @param object  Objekat koji zelimo da pronadjemo.
	 * @param columns null
	 * @param values null
	 * @throws Exception ako dodje do greske prilikom trazenja filmova.
	 */
    @Override
    protected void executeSpecificOperation(DomainObject object,List<String> columns, List<String> values) throws Exception {
        movies = (List<Movie>) (Object) dbb.getAllDomainObjects(new Movie());

    }
/**
 * Metoda koja vraca listu filmova.
 * @return listaFimova
 */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Metoda koja vrsi validaciju.
     */
	@Override
	protected void validate(DomainObject object) throws Exception {
	}

}
