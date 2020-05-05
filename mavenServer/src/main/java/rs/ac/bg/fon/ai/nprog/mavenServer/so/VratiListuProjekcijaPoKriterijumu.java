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

    /**
   	 * Metoda koja vraca listu projekcija iz baze po odredjenom kritrerijumu.
   	 * 
   	 * @param object  Objekat koji zelimo da pronadjemo.
  	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo listu projekcija.
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo listu projekcija.
   	 * @throws Exception ako dodje do greske prilikom trazenja projekcija.
   	 */
    @Override
    protected void executeSpecificOperation(DomainObject object, List<String> columns, List<String> values) throws Exception {
        showtimes = (List<Showtime>) (Object) dbb.getAllDomainObjectsWithWhere(new Showtime(), columns, values);
    }

    /**
     * Metoda koja vrsi validaciju
     * @param object
     * @throws Exception
     */
    @Override
    protected void validate(DomainObject object) throws Exception {
    }

    /**
     * Metoda koja vraca listu projekcija
     * @return
     */
    public List<Showtime> getShowtimes() {
        return showtimes;
    }

}
