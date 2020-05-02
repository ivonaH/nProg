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
 */
public class VratiListuFilmskihMaratona extends AbstractSystemOperation {

    List<MovieMarathon> movieMarathons;

    @Override
    protected void executeSpecificOperation(Object object,List<String> columns, List<String> values) throws Exception {
        movieMarathons = (List<MovieMarathon>) (Object) dbb.getAllDomainObjects(new MovieMarathon());
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<MovieMarathon> getMovieMarathons() {
        return movieMarathons;
    }

}
