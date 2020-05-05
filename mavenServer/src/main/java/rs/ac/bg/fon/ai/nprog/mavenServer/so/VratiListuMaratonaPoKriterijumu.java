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
*          Klasa VratiListuFilmskihMaratona predstavlja sistemsku operaciju koja vraca listu filmskih maratona iz baze po odredjenom kritrerijumu.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuMaratonaPoKriterijumu extends AbstractSystemOperation {
	/**
	 * Lista filmskih maratona.
	 */
    private List<MovieMarathon> marathons;

    /**
  	 * Metoda koja vraca listu filmskih maratona iz baze po odredjenom kritrerijumu.
  	 * 
  	 * @param object  Objekat koji zelimo da pronadjemo.
  	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo listu maratona.
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo listu maratona.
  	 * @throws Exception ako dodje do greske prilikom trazenja filmskih maratona.
  	 */
    @Override
    protected void executeSpecificOperation(DomainObject object, List<String> columns, List<String> values) throws Exception {
        marathons =(List<MovieMarathon>)(Object) dbb.getAllDomainObjectsWithWhere(new MovieMarathon(), columns, values);
    }

    /**
     * Metoda koja vrsi validaciju.
     */
    @Override
    protected void validate(DomainObject object) throws Exception {
    }

    /**
     * Metoda koja vraca filmske maratone.
     * @return lista filmskih maratona.
     */
    public List<MovieMarathon> getMarathons() {
        return marathons;
    }

}
