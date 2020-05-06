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
*          Klasa VratiListuFilmskihMaratona predstavlja sistemsku operaciju koja vraca listu filmskih maratona iz baze.
*          Nasledjuje AbstractSystemOperation.
*/
public class VratiListuFilmskihMaratona extends AbstractSystemOperation {
/**
 * Lista filmskih maratona.
 */
    List<MovieMarathon> movieMarathons;

    /**
	 * Metoda koja vraca listu filmskih maratona iz baze.
	 * 
	 * @throws Exception ako dodje do greske prilikom trazenja filmskih maratona.
	 */
    @Override
    protected void executeSpecificOperation() throws Exception {
        movieMarathons = (List<MovieMarathon>) (Object) dbb.getAllDomainObjects(new MovieMarathon());
    }

/**
 * Metoda koja vraca filmske maratone.
 * @return lista filmskih maratona.
 */
    public List<MovieMarathon> getMovieMarathons() {
        return movieMarathons;
    }

}
