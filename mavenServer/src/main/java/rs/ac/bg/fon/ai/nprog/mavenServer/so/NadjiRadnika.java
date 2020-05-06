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
 *          Klasa NadjiRadnika predstavlja sistemsku operaciju kojom se
 *          pronalazi korisnik u bazi. Nasledjuje AbstractSystemOperation.
 */
public class NadjiRadnika extends AbstractSystemOperation {
	/**
	 * Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo
	 * korisnika.
	 */
	List<String> columns;
	/**
	 * Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo
	 * korisnika.
	 */
	List<String> values;
	/**
	 * Korisnik (radnik).
	 */
	private User user;
	/**
	 * Parametrizovani konstruktor metode koja vraca korisnika po odredjenom kriterijumu.
	 * 
	 * @param columns Lista u kojoj su zadati nazivi kolona po kojima trazimo korisnika.
	 * @param values  Lista u kojoj su zadate vrednosti kolona po kojima trazimo korisnika.
	 * @throws Exception
	 */
	public NadjiRadnika(List<String> columns, List<String> values) {
		this.columns = columns;
		this.values = values;
	}

	/**
	 * Metoda koja pronalazi korisnika (radnika) u bazi.
	 * 
	 * 
	 * @throws Exception ako dodje do greske prilikom trazenja korisnika (radnika).
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		List<DomainObject> users = dbb.getAllDomainObjectsWithWhere(new User(), columns, values);
		if (users.size() != 0) {
			user = (User) users.get(0);
		}
	}

	/**
	 * Metoda koja vraca korisnika.
	 * 
	 * @return korisnik (radnik)
	 */
	public User getUser() {
		return user;
	}

}
