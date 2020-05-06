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
*          Klasa VratiListuFilmskihMaratona predstavlja sistemsku operaciju koja vraca listu projekcija iz baze po odredjenom kritrerijumu.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuProjekcijaPoKriterijumu extends AbstractSystemOperation {
/**
 * Lista projekcija
 */
    private List<Showtime> showtimes;

    /** Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo
 	 * listu projekcija.
 	 */
 	List<String> columns;
 	/**
 	 * Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo
 	 * listu projekcija.
 	 */
 	List<String> values;


 /**
 * Parametrizovani konstruktor metode koja vraca listu filmova po odredjenom kriterijumu.
 * 
 * @param columns Lista u kojoj su zadati nazivi kolona po kojima trazimo listu filmova.
 * @param values  Lista u kojoj su zadate vrednosti kolona po kojima trazimo filmove.
 * @throws Exception
 */
 	public VratiListuProjekcijaPoKriterijumu(List<String> columns, List<String> values) throws Exception {
 		this.columns = columns;
 		this.values = values;
 	}

    
    /**
   	 * Metoda koja vraca listu projekcija iz baze po odredjenom kritrerijumu.
   	 * 
   	 * @param object  Objekat koji zelimo da pronadjemo.
   	 * @throws Exception ako dodje do greske prilikom trazenja projekcija.
   	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        showtimes = (List<Showtime>) (Object) dbb.getAllDomainObjectsWithWhere(new Showtime(), columns, values);
    }

    /**
     * Metoda koja vraca listu projekcija
     * @return
     */
    public List<Showtime> getShowtimes() {
        return showtimes;
    }

}
