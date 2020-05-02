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
public class VratiListuProjekcijaPoKriterijumu extends AbstractSystemOperation {

    private List<Showtime> showtimes;

    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        showtimes = (List<Showtime>) (Object) dbb.getAllDomainObjectsWithWhere(new Showtime(), columns, values);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

}
