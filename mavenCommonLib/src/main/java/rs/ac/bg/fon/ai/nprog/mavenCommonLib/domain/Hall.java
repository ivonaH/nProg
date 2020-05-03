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
 * Klasa Hall predstvalja salu sa svim svojim atributima. Implementira interfejs
 * DomainObject i Serializable.
 *
 * @author Ivona
 * 
 * @version 1.0
 */
public class Hall implements DomainObject, Serializable {
	/**
	 * Indentikator sale.
	 */
	private int hallId;

	/**
	 * Naziv sale.
	 */
	private String name;

	/**
	 * Kapacitet sale.
	 */
	private int capacity;

	/**
	 * Parametrizovani konstruktor za klasu Hall.
	 * 
	 * @param hallId  predstavlja indentifikator sale
	 * @param name    predstavlja ime sale
	 * @param capcity predstavlja kapacitet sale
	 * 
	 */
	public Hall(int hallId, String name, int capacity) {
		this.hallId = hallId;
		this.name = name;
		this.capacity = capacity;
	}

	/**
	 * Neparametrizovani konstruktor za salu.
	 */
	public Hall() {
	}

	/**
	 * Get metoda za hallId.
	 * 
	 * @return indentifikator sale
	 */
	public int getHallId() {
		return hallId;
	}

	/**
	 * Set metoda za hallId.
	 * 
	 * @param indentifikator sale
	 */
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}

	/**
	 * Get metoda za ime sale.
	 * 
	 * @return ime sale
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set metoda za ime sale.
	 * 
	 * @param ime sale
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get metoda za kapacitet sale.
	 * 
	 * @return kapacitet sale
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Set metoda za kapacitet sale.
	 * 
	 * @param kapacitet sale
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca naziv tabele za domenski
	 * objekat Hall.
	 * 
	 * @return String koji predstavlja naziv tabele, u ovom slucaju "Hall".
	 */
	@Override
	public String getTableName() {
		return "Hall";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca vrednosti za salu koje
	 * zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja vrednosti (za salu) koje ubacujemo u tabelu;
	 *         u ovom slucaju to su indentifikator sale, naziv sale i kapacitet.
	 */
	@Override
	public String getParameters() {
		return String.format("%s, '%s', %s", hallId, name, capacity);
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca nazive kolona za Hall koje zelimo da sacuvamo u
	 * tabeli.
	 * 
	 * @return String koji predstavlja nazive kolona koji ubacujemo u tabelu;
	 * U ovom slucaju to su indentifikator sale, naziv i kapacitet sale.
	 */
	@Override
	public String getParameterNames() {
		return "HallId, Name, Capacity";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca vrednost primarnog kljuca za dati domenski objekat.
	 * 
	 * @return int vrednost indentifikatora sale
	 */
	@Override
	public int getPrimaryKeyValue() {
		return hallId;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca naziv primarnog kljuca za Hall.
	 * 
	 * @return String naziv primarnog kljuca za salu,
	 * u ovom slucaju to je HallId.
	 */
	@Override
	public String getPrimaryKeyName() {
		return "HallId";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda koja vraca naziv kolone i vrednost na koju ce ta kolona biti
	 * azurirana u tabeli Hall.
	 * 
	 * @return String naziv kolone i vrednost na koju ce ta kolona biti postavljena.
	 *         Na primer: " hallId=1, name='Pera', capacity=10"
	 */
	@Override
	public String getUpdateQuery() {
		return "HallId=" + hallId + ", Name='" + name + "', Capacity=" + capacity;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda koja cita iz ResultSeta listu sala.
	 * 
	 * @param rs ResultSet iz kog cemo procitati listu sala.
	 * @return Lista sala koje su procitani iz baze.
	 */
	@Override
	public List<DomainObject> convertRSList(ResultSet rs) {
		List<DomainObject> halls = new ArrayList<>();
		try {
			while (rs.next()) {
				int hallId = rs.getInt("HallId");
				String name = rs.getString("Name");
				int capacity = rs.getInt("Capacity");

				halls.add(new Hall(hallId, name, capacity));
			}
		} catch (Exception ex) {
			System.out.println("ERROR ResultSet User");
		}
		return halls;
	}

	 /**
     * Vraca string sa podacima o sali: <ol>
     * <li> name </ol>
     * @return String Podaci o sali u tekstualnom formatu.
     */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca uslov za spajanje tabele sa 2. tabelom.
	 * 
	 * @return String metoda vraca uslov za spajanje tabele Hall sa 2. tabelama.
	 */
	@Override
	public String getJoinCondition() {

		return null;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca uslov za sortiranje vrednosti za klasu Hall.
	 * 
	 * @return vraca vrednost po kom ce biti sortirani objekti klase Hall.
	 * U ovom slucaju to je "Name".
	 */
	@Override
	public String getSortCondition() {
		return "Name";
	}

	/**
	 * Proverava da li su dve sale iste. 
	 * Poredi sale po atributu <i><b> hallId</b></i>
	 * @param obj Hall koju zelimo da uporedimo sa zeljenom salom.
	 * @return true ako su dve sale iste po ovim parametrima, ako nisu vraca <b> false</b>.
	 */
	@Override
	public boolean equals(Object obj) {
		 if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
		Hall hall = (Hall) obj;
		return hall.hallId == this.hallId;
	}

}
