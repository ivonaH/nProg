/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.DomainObject;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DBBroker;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;
import java.util.List;

/**
 *
 * @author Ivona
 * 
 * @version 1.0
 * 
 *          AbstractSystemOperation predstavlja apstraktnu klasu koju nasledjuju
 *          sistemske operacije.
 */
public abstract class AbstractSystemOperation {
	/**
	 * dbb Predstavlja instancu klase DBBroker, tj brokera baze podataka.
	 */
	protected DBBroker dbb;

	/**
	 * Konstruktor AbstractSystemOperation u kom se inicijalizuje broker baze
	 * podataka.
	 */
	public AbstractSystemOperation() {
		dbb = new DBBroker();

	}

	/**
	 * Opsta metoda koja upravlja transakcijama vezanim za domenski objekat. Metoda
	 * prvo proverava validnost zadatog objekta. Postavlja konekciji auto commit na
	 * false. Kada se specificna operacija uspesno izvrsi, belezi je u bazu. U
	 * slucaju da se operacija ne izvrsi uspesno, promene se odbacuju.
	 * 
	 * 
	 * @param object  Objekat klase nad kojim vrsimo operaciju.
	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona.
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona.
	 * @throws Exception ako se operacija ne izvrsi uspesno.
	 */
	public final void executeOperation(DomainObject object, List<String> columns, List<String> values) throws Exception {
		try {
			validate(object);
			DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
			executeSpecificOperation(object, columns, values);
			DatabaseConnection.getInstance().getConnection().commit();
		} catch (Exception ex) {
			DatabaseConnection.getInstance().getConnection().rollback();
			throw ex;

		}
	}

	/**
	 * Apstraktna metoda u kojoj se pozivaju specificne operacije za domenski
	 * objekat.
	 * 
	 * @param object  Objekat klase nad kojim vrsimo operaciju.
	 * @param columns Predstavlja listu u kojoj ce biti zadati nazivi kolona.
	 * @param values  Predstavlja listu u kojoj ce biti zadati vrednosti kolona.
	 * @throws Exception ako se operacija ne izvrsi uspesno.
	 */
	protected abstract void executeSpecificOperation(DomainObject object, List<String> columns, List<String> values)
			throws Exception;

	/**
	 * Apstrakna metoda koja vrsi validaciju domenskog objekta.
	 * 
	 *  @param object  Objekat klase nad kojim vrsimo operaciju.
	 *  @throws Exception ako se validacija ne izvrsi uspesno.
	 */
	protected abstract void validate(DomainObject object) throws Exception;
}
