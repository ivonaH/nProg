/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

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
	 * Neparametrizovani konstruktor AbstractSystemOperation u kom se inicijalizuje broker baze
	 * podataka.
	 */
	public AbstractSystemOperation() {
		dbb = new DBBroker();

	}

	/**
	 * Opsta metoda koja upravlja transakcijama vezanim za domenski objekat.
	 * Postavlja konekciji auto commit na
	 * false. Kada se specificna operacija uspesno izvrsi, belezi je u bazu. U
	 * slucaju da se operacija ne izvrsi uspesno (dodje do izuzetka), promene se odbacuju.
	 * 
	 * 
	 * @throws Exception ako se operacija ne izvrsi uspesno.
	 */
	public final void executeOperation() throws Exception {
		try {
			DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
			executeSpecificOperation();
			DatabaseConnection.getInstance().getConnection().commit();
		} catch (Exception ex) {
			DatabaseConnection.getInstance().getConnection().rollback();
			throw ex;

		}
	}

	/**
	 * Apstraktna metoda u kojoj se pozivaju specificne operacije za domenski
	 * objekat.
	 * @throws Exception ako se operacija ne izvrsi uspesno.
	 */
	protected abstract void executeSpecificOperation()
			throws Exception;
	
	/**
	 * Metoda koja vraca instancu brokera baze podataka.
	 * @return instanca brokera baze podataka
	 */
	public DBBroker getDbb() {
		return dbb;
	}

}
