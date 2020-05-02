/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa MovieMarathon predstvalja filmski maraton sa svim svojim atributima.
 * Implementira interfejs DomainObject i Serializable.
 *
 * @author Ivona
 * 
 * @version 1.0
 */
public class MovieMarathon implements DomainObject, Serializable {

	/**
	 * indentifikator maratona
	 */
	private int marathonId;
	/**
	 * ime maratona
	 */
	private String name;
	/**
	 * korisnik koji je uneo maraton
	 */
	private User user;

	/**
	 * Neparametrizovani konstruktor za filmski maraton.
	 */
	public MovieMarathon() {
	}

	/**
	 * Parametrizovani konstruktor za filmski maraton.
	 * 
	 * @param marathonId indentifikator maratona
	 * @param name naziv maratona
	 * @param user korisnik koji je uneo maraton
	 */
	public MovieMarathon(int marathonId, String name, User user) {
		this.marathonId = marathonId;
		this.name = name;
		this.user = user;
	}

	/**
	 * Parametrizovani konstruktor za filmski maraton.
	 * 
	 * @param name naziv maratona
	 * @param user korisnik koji je uneo maraton
	 */
	public MovieMarathon(String name, User user) {
		this.name = name;
		this.user = user;
	}

	/**
	 * Parametrizovani konstruktor za filmski maraton.
	 * 
	 * @param marathonId indentifikator maratona
	 */
	public MovieMarathon(int movieMarathonId) {
		this.marathonId = movieMarathonId;
	}

	/**
	 * Get metoda za indentifikator maratona.
	 * 
	 * @return marathonId indentifikator maratona
	 */
	public int getMarathonId() {
		return marathonId;
	}

	/**
	 * Set metoda za indentifikator.
	 * 
	 * @param marathonId indentifikator maratona
	 */
	public void setMarathonId(int marathonId) {
		this.marathonId = marathonId;
	}

	/**
	 * Get metoda za ime maratona.
	 * 
	 * @return name ime maratona
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set metoda za ime maratona.
	 * 
	 * @param name ime maratona
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get metoda za korisnika koji je uneo maraton.
	 * 
	 * @return user koji je uneo maraton.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set metoda za korisnika koji je uneo maraton.
	 * 
	 * @param user koji je uneo maraton
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca naziv tabele
	 * za domenski objekat MovieMarathon.
	 * 
	 * @return String koji predstavlja naziv tabele, u ovom slucaju "MovieMarathon".
	 */
	@Override
	public String getTableName() {
		return "MovieMarathon";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca vrednosti za
	 * filmski maraton koje zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja vrednosti (za filmski paraton) koje ubacujemo
	 *         u tabelu; u ovom slucaju to su indentifikator id maratona, naziv
	 *         maratona i korisnik koji je uneo maraton.
	 */
	@Override
	public String getParameters() {
		return String.format("%s, '%s', %s", marathonId, name, user.getUserId());
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca nazive kolona
	 * za MovieMarathon koje zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja nazive kolona koji ubacujemo u tabelu
	 *         filmskih maratona.
	 */
	@Override
	public String getParameterNames() {
		return "MarathonId, Name, UserId";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca vrednost
	 * primarnog kljuca za dati filmski maraton.
	 * 
	 * @return int vrednost indentifikatora filmskog maratona
	 */
	@Override
	public int getPrimaryKeyValue() {
		return marathonId;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca naziv
	 * primarnog kljuca za Hall.
	 * 
	 * @return String naziv primarnog kljuca za filmski maraton, u ovom slucaju to
	 *         je MarathonId.
	 */
	@Override
	public String getPrimaryKeyName() {
		return "MarathonId";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda koja cita iz
	 * ResultSeta listu filmskih maratona.
	 * 
	 * @param rs ResultSet iz kog cemo procitati listu filmskih maratona.
	 * @return Lista filmskih maratona koje su procitani iz baze.
	 */
	@Override
	public List<DomainObject> convertRSList(ResultSet rs) {
		List<DomainObject> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int marathonId = rs.getInt("MarathonId");
				String name = rs.getString("Name");
				int id = rs.getInt("UserId");

				list.add(new MovieMarathon(marathonId, name, new User(id)));
			}
		} catch (Exception ex) {
			System.out.println("ERROR ResultSet " + getTableName());
		}

		return list;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda koja vraca naziv
	 * kolone i vrednost na koju ce ta kolona biti azurirana u tabeli MovieMarathon.
	 * 
	 * @return String naziv kolone i vrednost na koju ce ta kolona biti postavljena.
	 */
	@Override
	public String getUpdateQuery() {
		return "MarathonId=" + marathonId;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca uslov za
	 * spajanje tabele sa 2. tabelom.
	 * 
	 * @return String metoda vraca uslov za spajanje tabele MovieMarathon sa 2.
	 *         tabelama.
	 */
	@Override
	public String getJoinCondition() {
		return null;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca uslov za
	 * sortiranje vrednosti za klasu Movie.
	 * 
	 * @return vraca vrednost po kom ce biti sortirani objekti klase MovieMarathon.
	 *         U ovom slucaju to je "Name".
	 */
	@Override
	public String getSortCondition() {
		return "name";
	}

}
