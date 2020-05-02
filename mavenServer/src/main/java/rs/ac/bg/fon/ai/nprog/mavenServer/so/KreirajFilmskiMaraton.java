/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.DomainObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivona
 */
public class KreirajFilmskiMaraton extends AbstractSystemOperation {

    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        MovieMarathon mm = (MovieMarathon) ((ArrayList<Object>) object).get(0);
        ArrayList<DomainObject> showtimes = (ArrayList<DomainObject>) ((ArrayList<Object>) object).get(1);
        mm.setMarathonId(dbb.generateId(mm));
        dbb.saveDomainObject(mm);
        dbb.updateDomainObjects(showtimes, "movieMarathonId", mm.getMarathonId() + "");
    }

    @Override
    protected void validate(Object object) throws Exception {
    	if (!(object instanceof MovieMarathon)) {
            throw new Exception("Objekat nije instanca klase FilmskiMaraton!");
        }
    }
}
