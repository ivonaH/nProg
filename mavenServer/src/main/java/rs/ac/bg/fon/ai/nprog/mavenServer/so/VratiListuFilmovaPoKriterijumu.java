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
	 * Lista filmova ucitana iz baze po odredjenom kriterijumu pretrage.
	 */
    private List<Movie> movies;
    
   /** Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo
	 * listu filmova.
	 */
	List<String> columns;
	/**
	 * Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo
	 * listu filmova.
	 */
	List<String> values;


/**
* Parametrizovani konstruktor metode koja vraca listu filmova po odredjenom kriterijumu.
* 
* @param columns Lista u kojoj su zadati nazivi kolona po kojima trazimo listu filmova.
* @param values  Lista u kojoj su zadate vrednosti kolona po kojima trazimo filmove.
*/
	public VratiListuFilmovaPoKriterijumu(List<String> columns, List<String> values) {
		this.columns = columns;
		this.values = values;
	}

    
    /**
  	 * Metoda koja vraca listu filmova iz baze po odredjenom kritrerijumu.
  	 * 
  	 * @throws Exception ako dodje do greske prilikom trazenja filmova.
  	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        movies = (List<Movie>) (Object) dbb.getAllDomainObjects(new Movie(), columns, values);
    }
    
    /**
     * Metoda koja vraca listu filmova po zadatom kriterijumu.
     * @return listaFimova
     */
    public List<Movie> getMovies() {
        return movies;
    }

}
