/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import java.sql.ResultSet;
import java.util.List;

/**
 * Interfejs DomainObject predstavlja domenski objekat kog nasledjuju klase u
 * paketu domain.
 *
 * @author Ivona
 * 
 * @version 1.0
 */
public interface DomainObject {
	/**
	 * Metoda vraca naziv tabele.
	 * 
	 * @return String koji predstavlja naziv tabele.
	 */
	String getTableName();

	/**
	 * Metoda vraca vrednosti parametara za domenski objekat koji zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja vrednosti parametara (za dati domenski objekat) koje
	 *         ubacujemo u tabelu.
	 */
	String getParameters();

	/**
	 ** Metoda vraca nazive kolona za domenski objekat koji zelimo da sacuvamo u
	 * tabeli.
	 * 
	 * @return String koji predstavlja nazive kolona koji ubacujemo u tabelu.
	 */
	String getParameterNames();

	/**
	 * Metoda vraca vrednost primarnog kljuca za dati domenski objekat.
	 * 
	 * @return int vrednost primarnog kljuca domenskog objekta.
	 */
	int getPrimaryKeyValue();

	/**
	 * Metoda vraca naziv primarnog kljuca za dati domenski objekat.
	 * 
	 * @return String naziv primarnog kljuca domenskog objekta.
	 */
	String getPrimaryKeyName();

	/**
	 * Metoda koja cita iz ResultSeta listu domenskih objekata.
	 * 
	 * @param rs ResultSet iz kog cemo procitati listu domenskih objekata.
	 * @return Lista domenskih objekata koji su procitani iz baze.
	 */
	List<DomainObject> convertRSList(ResultSet rs);

	/**
	 * Metoda koja vraca naziv kolone i vrednost na koju ce ta kolona biti
	 * postavljena.
	 * 
	 * @return String naziv kolone i vrednost na koju ce ta kolona biti azurirana.
	 *         Na primer: " hallId=1"
	 */
	String getUpdateQuery();

	/**
	 * Metoda vraca uslov za spajanje tabele sa 2. tabelom.
	 * 
	 * @return String metoda vraca uslov za spajanje tabele sa 2. tabelama.
	 */
	String getJoinCondition();
	/**
	 * Metoda vraca uslov za sortiranje vrednosti.
	 * 
	 * @return String string uslov za sortiranje.
	 * Na primer: "time asc".
	 */
	String getSortCondition();
}
