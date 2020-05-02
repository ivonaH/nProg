/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivona
 */
public class NadjiRadnika extends AbstractSystemOperation {

    private User user;

    @Override
    protected void executeSpecificOperation(Object object,List<String> columns, List<String> values) throws Exception {
        System.out.println("USAO U SO.NADJI_RADNIKA");
        User u = (User) object;
        List<DomainObject> users = dbb.getAllDomainObjectsWithWhere(new User(), columns, values);
        if (users.size() != 0) {
            user = (User) users.get(0);
        }

    }

    @Override
    protected void validate(Object object) throws ValidationException {
        if (!(object instanceof User)) {
            throw new ValidationException("Objekat nije instanca klase User.");
        }
    }

    public User getUser() {
        return user;
    }

}
