/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import java.util.List;

/**
*
* @author Ivona
* 
* @version 1.0
* 
*          Klasa NadjiRadnika predstavlja sistemsku operaciju kojom se pronalazi korisnik u bazi.
*          Nasledjuje AbstractSystemOperation.
*/
public class NadjiRadnika extends AbstractSystemOperation {
/**
 * Korisnik (radnik).
 */
    private User user;
	/**
	 * Metoda koja pronalazi korisnika (radnika) u bazi.
	 * 
	 * 
	 * @param object  Objekat koji zelimo da pronadjemo.
	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo korisnika (radnika).
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo korisnika (radnika).
	 * @throws Exception ako dodje do greske prilikom trazenja korisnika (radnika).
	 */
    @Override
    protected void executeSpecificOperation(Object object,List<String> columns, List<String> values) throws Exception {
        List<DomainObject> users = dbb.getAllDomainObjectsWithWhere(new User(), columns, values);
        if (users.size() != 0) {
            user = (User) users.get(0);
        }
    }

    /**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase
	 * User.
	 * 
	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
	 *               User.
	 * @throws Exception ako objekat nije instanca klase User.
	 * 
	 */
    @Override
    protected void validate(Object object) throws ValidationException {
        if (!(object instanceof User)) {
            throw new ValidationException("Objekat nije instanca klase User.");
        }
    }

    /**
     * Metoda koja vraca korisnika.
     * @return korisnik (radnik)
     */
    public User getUser() {
        return user;
    }

}
