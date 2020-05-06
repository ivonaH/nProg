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
	 * objekat koji zelimo da obrisemo.
	 */
	Showtime showtime;

	/**
	 * Parametrizovani konstruktor metode obrisi projekciju.
	 * 
	 * @param object koji zelimo da obrisemo
	 * @throws Exception ako primljeni objekat nije instanca klase Showtime
	 */
	public ObrisiProjekciju(Object object) throws Exception {
		validate(object);
		this.showtime = (Showtime) object;
	}
	
	/**
	 * Metoda koja brise projekciju iz baze.
	 * 
	 * @throws Exception ako dodje do greske prilikom brisanja objekta iz baze.
	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        dbb.deleteDomainObject(showtime);
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
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Showtime)) {
            throw new Exception("Objekat nije instanca klase Projekcija!");
        }
    }

}
