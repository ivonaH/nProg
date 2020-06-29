/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivona
 * 
 * @version 1.0
 * 
 *          Klasa VratiListuFilmskihMaratona predstavlja sistemsku operaciju
 *          koja vraca listu filmskih maratona iz baze po odredjenom
 *          kritrerijumu. Nasledjuje AbstractSystemOperation.
 */
public class VratiListuMaratonaPoKriterijumu extends AbstractSystemOperation {
	/**
	 * Predstavlja listu u kojoj ce biti zadati nazivi kolona po kojima trazimo
	 * listu maratona.
	 */
	List<String> columns;
	/**
	 * Predstavlja listu u kojoj ce biti zadati vrednosti kolona po kojima trazimo
	 * listu maratona.
	 */
	List<String> values;
	/**
	 * Lista filmskih maratona.
	 */
	private List<MovieMarathon> marathons;

/**
 * Parametrizovani konstruktor metode koja vraca listu filmskih maratona po odredjenom kriterijumu.
 * 
 * @param columns Lista u kojoj su zadati nazivi kolona po kojima trazimo listu maratone.
 * @param values  Lista u kojoj su zadate vrednosti kolona po kojima trazimo maratone.
 */
	public VratiListuMaratonaPoKriterijumu(List<String> columns, List<String> values){
		this.columns = columns;
		this.values = values;
	}

	/**
	 * Metoda koja vraca listu filmskih maratona iz baze po odredjenom kritrerijumu.	  
	 * @throws Exception ako dodje do greske prilikom trazenja filmskih maratona.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		marathons = (List<MovieMarathon>) (Object) dbb.getAllDomainObjects(new MovieMarathon(), columns,
				values);
	}


	/**
	 * Metoda koja vraca filmske maratone.
	 * 
	 * @return lista filmskih maratona.
	 */
	public List<MovieMarathon> getMarathons() {
		return marathons;
	}

}
