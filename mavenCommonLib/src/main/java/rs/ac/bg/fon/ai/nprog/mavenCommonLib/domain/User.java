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
import java.util.Objects;

/**
 * Klasa User predstvalja korisnika sa svim svojim atributima. Implementira interfejs
 * DomainObject i Serializable.
 *
 * @author Ivona
 * 
 * @version 1.0
 */
public class User implements DomainObject, Serializable {

    /**
	 * indentifikator korisnika
	 */
	private int userId;
	/**
	 * korisnicko ime
	 */
    private String username;
    /**
     * ime
     */
    private String name;
    /**
     * prezime
     */
    private String lastname;
    /**
     * sifra
     */
    private String password;

    /**
     * Neparametrizovani konstruktor za korisnika.
     */
    public User() {
    }

    /**
     * Parametrizovani konstruktor za korisnika
     * @param username korisnicko ime
     * @param password sifra
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Parametrizovani konstruktor za korisnika
     * @param userId indentifikator korisnika
     * @param username korisnicko ime
     * @param name ime
     * @param lastname prezime
     * @param password sifra
     */
    public User(int userId, String username, String name, String lastname, String password) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }
	/**
	 * Parametrizovani konstruktor za korisnika
	 * @param userId indentifikator korisnika
	 */
   public User(int userId) {
        this.userId = userId;
    }

   /**
	 * get metoda za userId.
	 * 
	 * @return indentifikator korisnika
	 */
    public int getUserId() {
        return userId;
    }

    /**
	 * Set metoda za userId.
	 * 
	 * @param indentifikator korisnika
	 */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca naziv tabele za domenski
	 * objekat User.
	 * 
	 * @return String koji predstavlja naziv tabele, u ovom slucaju "User".
	 */
    @Override
    public String getTableName() {
        return "user";
    }

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca vrednosti za salu koje
	 * zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja vrednosti (za korsnika) koje ubacujemo u tabelu;
	 *         u ovom slucaju to su indentifikator korisnika, naziv korisnika, sifra, ime i prezime.
	 */
    @Override
    public String getParameters() {
        return String.format("%s, '%s','%s','%s','%s'", userId, username, password, name, lastname);
    }

    /**
   	 * Implementirana metoda iz interfejsa DomainObject.
   	 * Metoda vraca nazive kolona za User-a koje zelimo da sacuvamo u
   	 * tabeli.
   	 * 
   	 * @return String koji predstavlja nazive kolona koji ubacujemo u tabelu korisnika.
   	 */
    @Override
    public String getParameterNames() {
        return "UserId,Username,Password,Name,Lastname";
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca vrednost primarnog kljuca za datog korisnika.
	 * 
	 * @return int vrednost indentifikatora korisnika
	 */
    @Override
    public int getPrimaryKeyValue() {
        return userId;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca naziv primarnog kljuca za Usera.
	 * 
	 * @return String naziv primarnog kljuca za korisnika,
	 * u ovom slucaju to je UserId.
	 */
    @Override
    public String getPrimaryKeyName() {
        return "userId";
    }

    /**
  	 * Implementirana metoda iz interfejsa DomainObject.
  	 * Metoda koja cita iz ResultSeta listu korisnika.
  	 * 
  	 * @param rs ResultSet iz kog cemo procitati listu korisnika.
  	 * @return Lista korisnika koje su procitani iz baze.
  	 */
    @Override
    public List<DomainObject> convertRSList(ResultSet rs) {
        List<DomainObject> users = new ArrayList<>();
        try {
            while (rs.next()) {
                int userId = rs.getInt("UserId");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String name = rs.getString("Name");
                String lastname = rs.getString("Lastname");

                users.add(new User(userId, username, name, lastname, password));
            }
        } catch (Exception ex) {
            System.out.println("ERROR ResultSet User");
        }
        return users;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda koja vraca naziv kolone i vrednost na koju ce ta kolona biti
	 * azurirana u tabeli User.
	 * 
	 * @return String naziv kolone i vrednost na koju ce ta kolona biti postavljena.
	 */
    @Override
    public String getUpdateQuery() {
        return "UserId="+userId+", Username='"+username+"', Password='"+password+"', Name='"+name+"', Lastname='"+lastname+"'";
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca uslov za spajanje tabele sa 2. tabelom.
	 * 
	 * @return String metoda vraca uslov za spajanje tabele User sa 2. tabelama.
	 */
    @Override
    public String getJoinCondition() {
        return null;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca uslov za sortiranje vrednosti za klasu User.
	 * 
	 * @return vraca vrednost po kom ce biti sortirani objekti klase User.
	 */
    @Override
    public String getSortCondition() {
       return null; 
    }

    /**
	 * Proverava da li su dva korisnika ista. 
	 * Poredi filmove po atributu: <i><b> username.</b></i>
	 * @param obj User koju zelimo da uporedimo sa zeljenim korisnikom.
	 * @return true ako su dva korisnika ista po ovim parametrima, ako nisu vraca <b> false</b>.
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }


}
