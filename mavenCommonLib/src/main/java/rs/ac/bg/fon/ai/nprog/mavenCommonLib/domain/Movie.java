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
 * Klasa Movie predstvalja film sa svim svojim atributima. Implementira interfejs
 * DomainObject i Serializable.
 *
 * @author Ivona
 * 
 * @version 1.0
 */
public class Movie implements DomainObject, Serializable  {

    /**
	 * Indentifikator filma
	 */
	private int movieId;
	/**
	 * Naziv filma
	 */
    private String name;
    /**
     * Objekat klase genre koji predstavlja zanr filma.
     */
    private Genre genre;
    /**
     * Reziser filma
     */
    private String director;
    /**
     * Godina objavljivanja filma.
     */
    private int year;
    /**
     * Korisnik koji je uneo film.
     */
    private User user;
    /**
     * Trajanje filma u minutima.
     */
    private int durationInMinutes;
    
    
	/**
	 * Neparametrizovani konstruktor za film.
	 */
    public Movie() {
    }

    /**
     * Parametrizovani konstruktor za film
     * @param movieId indentifikator filma
     * @param name naziv filma
     * @param genre zanr filma
     * @param director reziser filma
     * @param year godina objavljivanja filma
     * @param durationInMinutes trajanje filma u minutima
     * @param user korisnik koji je uneo film
     */
    public Movie(int movieId, String name, Genre genre, String director, int year, int durationInMinutes, User user) {
        this.movieId = movieId;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
        this.user = user;
        this.durationInMinutes = durationInMinutes;
    }

    /**
     * Parametrizovani konstruktor za film
     * @param name naziv filma
     * @param genre zanr filma
     * @param director reziser filma
     * @param year godina objavljivanja filma
     * @param durationInMinutes trajanje filma u minutima
     * @param user korisnik koji je uneo film
     */
    public Movie(String name, Genre genre, String director, int year, int durationInMinutes, User user) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
        this.user = user;
        this.durationInMinutes = durationInMinutes;
    }

    /**
     * Parametrizovani konstruktor za film
     * @param movieId indentifikator filma
     * @param name naziv filma
     */
    Movie(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    /**
     * Parametrizovani konstruktor za film
     * @param movieId indentifikator filma
     * @param movieName naziv filma
     * @param year godina objavljivanja filma
     * @param durationInMinutes trajanje filma u minutima
     */
    Movie(int movieId, String movieName, int year, int durationInMinutes) {
        this.movieId = movieId;
        this.name = movieName;
        this.year = year;
        this.durationInMinutes = durationInMinutes;
    }

    /**
	 * Get metoda za movieId.
	 * 
	 * @return indentifikator filma
	 */
    public int getMovieId() {
        return movieId;
    }

    /**
	 * Set metoda za movieId.
	 * 
	 * @param movieId indentifikator filma
	 */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    /**
   	 * Set metoda za naziv filma.
   	 * 
   	 * @param name naziv filma filma
   	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Get metoda za zanr
	 * 
	 * @return zanr filma
	 */
    public Genre getGenre() {
        return genre;
    }

    /**
   	 * Set metoda za genre.
   	 * 
   	 * @param genre zanr filma
   	 */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
	 * Get metoda za rezisera.
	 * 
	 * @return reziser
	 */
    public String getDirector() {
        return director;
    }

    
    /**
   	 * Set metoda za rezisera.
   	 * 
   	 * @param director reziser filma
   	 */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
	 * Get metoda za godinu objavljivanja filma.
	 * 
	 * @return godina objavljivanja filma
	 */
    public int getYear() {
        return year;
    }

    /**
   	 * Set metoda za godinu objavljivanja filma.
   	 * 
   	 * @param year godina objavljivanja filma
   	 */
    public void setYear(int year) {
        this.year = year;
    }

    /**
	 * Get metoda za korisnika.
	 * 
	 * @return korisnik koji je uneo film
	 */
    public User getUser() {
        return user;
    }

    /**
   	 * Set metoda za korisnika.
   	 * 
   	 * @param user korisnik koji je uneo film
   	 */
    public void setUser(User user) {
        this.user = user;
    }

    /**
	 * Get metoda za trajanje filma u minutima.
	 * 
	 * @return trajanje filma u minutima
	 */
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    /**
   	 * Set metoda za trajanje filma u minutima.
   	 * 
   	 * @param durationInMinutes trajanje filma u minutima
   	 */
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    
    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca naziv tabele za domenski
	 * objekat Movie.
	 * 
	 * @return String koji predstavlja naziv tabele, u ovom slucaju "Movie".
	 */
    @Override
    public String getTableName() {
        return "Movie";
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca vrednosti za film koje
	 * zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja vrednosti (za film) koje ubacujemo u tabelu;
	 */
    @Override
    public String getParameters() {
        return String.format("%s, '%s','%s','%s',%s,%s, %s", movieId, name, genre, director, year, durationInMinutes, user.getUserId());
    }

    /**
   	 * Implementirana metoda iz interfejsa DomainObject.
   	 * Metoda vraca nazive kolona za Movie koje zelimo da sacuvamo u
   	 * tabeli.
   	 * 
   	 * @return String koji predstavlja nazive kolona koji ubacujemo u tabelu filmova.
   	 */
    @Override
    public String getParameterNames() {
        return "movieId, name, genre, director, year, durationInMinutes, userId";
    }

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca vrednost primarnog kljuca za film.
	 * 
	 * @return int vrednost indentifikatora filma
	 */
    @Override
    public int getPrimaryKeyValue() {
        return movieId;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca naziv primarnog kljuca za Movie.
	 * 
	 * @return String naziv primarnog kljuca za film,
	 * u ovom slucaju to je MovieId.
	 */
    @Override
    public String getPrimaryKeyName() {
        return "MovieId";
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda koja cita iz ResultSeta listu filmova.
	 * 
	 * @param rs ResultSet iz kog cemo procitati listu filmova.
	 * @return Lista filmova koje su procitani iz baze.
	 */
    @Override
    public List<DomainObject> convertRSList(ResultSet rs) {
        List<DomainObject> list = new ArrayList<>();
        try {
            while (rs.next()) {
                int movieId = rs.getInt("MovieId");
                String name = rs.getString("Name");
                String g = rs.getString("Genre");
                Genre genre = Genre.valueOf(g);
                String director = rs.getString("Director");
                int year = rs.getInt("Year");
                int duration = rs.getInt("DurationInMinutes");
                int userId = rs.getInt("UserId");
                list.add(new Movie(movieId, name, genre, director, year, duration, new User(userId)));

            }
        } catch (Exception ex) {
            System.out.println("ERROR ResultSet " + getTableName());
        }

        return list;
    }

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda koja vraca naziv kolone i vrednost na koju ce ta kolona biti
	 * azurirana u tabeli Movie.
	 * 
	 * @return String naziv kolone i vrednost na koju ce ta kolona biti postavljena.
	 */
    @Override
    public String getUpdateQuery() {
        return "MovieId=" + movieId + ", Name='" + name + "', Genre='" + genre + "', director='" + director + "', Year=" + year + ",DurationInMinutes=" + durationInMinutes + " UserId=" + user.getUserId();
    }

    /**
     * Vraca string sa podacima o filmu: <ol>
     * <li> name</li> <li>year</li></ol>
     * @return String Podaci o filmu u tekstualnom formatu.
     */
    @Override
    public String toString() {
        return name + " " + year;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca uslov za spajanje tabele sa 2. tabelom.
	 * 
	 * @return String metoda vraca uslov za spajanje tabele Movie sa 2. tabelama.
	 */
    @Override
    public String getJoinCondition() {
        return null;
    }

	/**
	 * Proverava da li su dva filma ista. 
	 * Poredi filmove po atributima: <i><b> movieId, year, name, director, genre.</b></i>
	 * @param obj Movie koju zelimo da uporedimo sa zeljenim filmom.
	 * @return true ako su dva filma iste po ovim parametrima, ako nisu vraca <b> false</b>.
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
        final Movie other = (Movie) obj;
        if (this.movieId != other.movieId) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (this.genre != other.genre) {
            return false;
        }
        return true;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca uslov za sortiranje vrednosti za klasu Movie.
	 * 
	 * @return vraca vrednost po kom ce biti sortirani objekti klase Movie.
	 * U ovom slucaju to je po godini opadajuce i po imenu rastuce.
	 */
    @Override
    public String getSortCondition() {
        return "year DESC, name ASC";
    }

    
}
