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
public class VratiListuRezervacijaPoKriterijumu extends AbstractSystemOperation {

    private List<Reservation> reservations;

    @Override
    
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        reservations=(List<Reservation>)(Object) dbb.getAllDomainObjectsWithWhere(new Reservation(), columns, values);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

}
