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
public class KreirajProjekciju extends AbstractSystemOperation {

    @Override
    protected void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception {
        Showtime showtime = (Showtime) object;
        showtime.setShowtimeId(dbb.generateId(showtime));
        dbb.saveDomainObject(showtime);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Showtime)) {
            throw new Exception("Objekat nije instanca klase Projekcija!");
        }
    }
}
