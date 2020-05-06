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
*          Klasa ObrisiProjekciju predstavlja sistemsku operaciju kojom se brise projekcija iz baze.
*          Nasledjuje AbstractSystemOperation.
*/
public class ObrisiProjekciju extends AbstractSystemOperation {

	/**
	 * Metoda koja brise projekciju iz baze.
	 * 
	 * 
	 * @param object  Objekat koji zelimo da obrisemo iz baze.
	 * @param columns null
	 * @param values  null
	 * @throws Exception ako dodje do greske prilikom brisanja objekta iz baze.
	 */
    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        dbb.deleteDomainObject((DomainObject)object);
    }

    /**
   	 * Metoda koja vrsi validaciju da li je objekat instanca klase
   	 * Showtime.
   	 * 
   	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
   	 *               Showtime.
   	 * @throws Exception ako objekat nije instanca klase Showtime.
   	 * 
   	 */
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Showtime)) {
            throw new Exception("Objekat nije instanca klase Projekcija!");
        }
    }

}
