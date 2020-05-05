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
*          Klasa VratiListuFilmova predstavlja sistemsku operaciju koja vracu listu sala iz baze.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuSala extends AbstractSystemOperation {
/**
 * Lista sala
 */
    List<Hall> halls;
    
    /**
  	 * Metoda koja vraca listu sala iz baze.
  	 * 
  	 * @param object  Objekat koji zelimo da pronadjemo.
  	 * @param columns null
  	 * @param values null
  	 * @throws Exception ako dodje do greske prilikom trazenja sala.
  	 */
    @Override
    protected void executeSpecificOperation(DomainObject object, List<String> columns, List<String> values) throws Exception {
        halls= (List<Hall>)(Object)dbb.getAllDomainObjects(new Hall());
    }

    /**
     * Metoda koja vrsi validaciju.
     */
    @Override
    protected void validate(DomainObject object) throws Exception {
    }
/**
 * Metoda koaj vraca listu sala
 * @return listaSala
 */
    public List<Hall> getHalls() {
        return halls;
    }

}
