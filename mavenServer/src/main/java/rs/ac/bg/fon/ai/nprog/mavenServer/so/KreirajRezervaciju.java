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
public class KreirajRezervaciju extends AbstractSystemOperation {

    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        Reservation reservation = (Reservation) object;
        reservation.setReservationId(dbb.generateId(reservation));
        dbb.saveDomainObject(reservation);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Reservation)) {
            throw new Exception("Objekat nije instanca klase Rezervacija!");
        }
    }
}
