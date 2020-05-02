/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import java.util.List;

/**
 *
 * @author Ivona
 */
public class KreirajFilm extends AbstractSystemOperation {
    
    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        Movie movie = (Movie) object;
        movie.setMovieId(dbb.generateId(movie));
        dbb.saveDomainObject(movie);
    }
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Movie)) {
            throw new Exception("Objekat nije instanca klase Film!");
        }
    }
    
}
