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
	 * @throws Exception ako dodje do greske prilikom trazenja filmova.
	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        movies = (List<Movie>) (Object) dbb.getAllDomainObjects(new Movie());

    }
/**
 * Metoda koja vraca listu filmova.
 * @return listaFimova
 */
    public List<Movie> getMovies() {
        return movies;
    }


}
