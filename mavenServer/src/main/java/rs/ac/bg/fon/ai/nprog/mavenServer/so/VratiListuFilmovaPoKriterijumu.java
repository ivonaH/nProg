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
*          Klasa VratiListuFilmova predstavlja sistemsku operaciju koja vraca listu filmova iz baze po odredjenom kritrerijumu.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuFilmovaPoKriterijumu extends AbstractSystemOperation {
	/**
	 * Lista filmova.
	 */
    private List<Movie> movies;
    /**
  	 * Metoda koja vraca listu filmova iz baze po odredjenom kritrerijumu.
  	 * 
  	 * @param object  Objekat koji zelimo da pronadjemo.
  	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo listu filmova.
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo listu filmova.
  	 * @throws Exception ako dodje do greske prilikom trazenja filmova.
  	 */
    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        movies = (List<Movie>) (Object) dbb.getAllDomainObjectsWithWhere(new Movie(), columns, values);
    }

    /**
     * Metoda koja vrsi validaciju.
     */
    @Override
    protected void validate(Object object) throws Exception {
    }
    
    /**
     * Metoda koja vraca listu filmova.
     * @return listaFimova
     */
    public List<Movie> getMovies() {
        return movies;
    }

}
