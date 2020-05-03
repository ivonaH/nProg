/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Reservation predstvalja rezervaciju sa svim svojim atributima. Implementira interfejs
 * DomainObject i Serializable.
 *
 * @author Ivona
 * 
 * @version 1.0
 */
public class Reservation implements DomainObject, Serializable  {

    /**
	 * indentifikator rezervacije
	 */
	private int reservationId;
	/**
	 * ime i prezime osobe na koju se vrsi rezervacija
	 */
    private String nameLastname;
    /**
	 * email osobe na koju se vrsi rezervacija
	 */
    private String email;
    /**
	 * korisnik koji je uneo rezervaciju
	 */
    private User user;
    /**
	 * projekcija koja se rezervise
	 */
    private Showtime showtime;

    /**
     * Neparametrizovani konstruktor za rezervaciju.
     */
    public Reservation() {
    }

    /**
     * Neparametrizovani konstruktor za rezervaciju.
     * @param reservationId indentifikator rezervacije
     * @param nameLastname ime i prezime osobe na koju se vrsi rezervacija
     * @param email osobe na koju se vrsi rezervacija
     * @param user korisnik koji je uneo rezervaciju
     * @param showtime projekcija koja se rezervise
     */
    public Reservation(int reservationId, String nameLastname, String email, User user, Showtime showtime) {
        this.reservationId = reservationId;
        this.nameLastname = nameLastname;
        this.email = email;
        this.user = user;
        this.showtime = showtime;
    }
    
    /**
     * Neparametrizovani konstruktor za rezervaciju.
     * @param nameLastname ime i prezime osobe na koju se vrsi rezervacija
     * @param email osobe na koju se vrsi rezervacija
     * @param user korisnik koji je uneo rezervaciju
     * @param showtime projekcija koja se rezervise
     */
    public Reservation( String nameLastname, String email, User user, Showtime showtime) {
        this.nameLastname = nameLastname;
        this.email = email;
        this.user = user;
        this.showtime = showtime;
    }
    /**
   	 * get metoda za indentifikator rezervacije.
   	 * 
   	 * @return reservationId indentifikator rezervacije
   	 */
    public int getReservationId() {
        return reservationId;
    }
    
	/**
	 * Set metoda za indentifikator rezervaije.
	 * 
	 * @param reservationId indentifikator rezervacije
	 */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    /**
   	 * get metoda za ime i prezime za osobu na koju se vrsi rezervacija.
   	 * 
   	 * @return nameLastname ime i prezime za osobu na koju se vrsi rezervacija.
   	 */
    public String getNameLastname() {
        return nameLastname;
    }

	/**
	 * Set metoda za ime i prezime za osobu na koju se vrsi rezervacija.
	 * 
	 * @param nameLastname ime i prezime za osobu na koju se vrsi rezervacija.
	 */
    public void setNameLastname(String nameLastname) {
        this.nameLastname = nameLastname;
    }

    /**
   	 * get metoda za email osobe na koju se vrsi rezervacija.
   	 * 
   	 * @return email osobe na koju se vrsi rezervacija.
   	 */
    public String getEmail() {
        return email;
    }

    /**
	 * Set metoda za email za osobu na koju se vrsi rezervacija.
	 * 
	 * @param email za osobu na koju se vrsi rezervacija.
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
 	 * Get metoda za korisnika.
 	 * 
 	 * @return korisnik koji je uneo rezervaciju
 	 */
     public User getUser() {
         return user;
     }

     /**
    	 * Set metoda za korisnika.
    	 * 
    	 * @param korisnik koji je uneo rezervaciju
    	 */
     public void setUser(User user) {
         this.user = user;
     }

     /**
  	 * Get metoda za projekciju.
  	 * 
  	 * @return projekcija
  	 */
    public Showtime getShowtime() {
        return showtime;
    }

    /**
	 * Set metoda za projekciju.
	 * 
	 * @param projekcija
	 */
    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca naziv tabele za domenski
	 * objekat Reservation.
	 * 
	 * @return String koji predstavlja naziv tabele, u ovom slucaju "Reservation".
	 */
    @Override
    public String getTableName() {
        return "Reservation";
    }

	/**
	 * Implementirana metoda iz interfejsa DomainObject.
	 *  Metoda vraca vrednosti za rezervaciju koje
	 * zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja vrednosti (za rezervaciju) koje ubacujemo u tabelu;
	 *         u ovom slucaju to su indentifikator rezervacije, ime i prezime, email, id korisnika koji je uneo rezervaciju i id rezervacije.
	 */
    @Override
    public String getParameters() {
        return String.format("%s, '%s','%s', %s, %s", reservationId, nameLastname, email, user.getUserId(), showtime.getShowtimeId());
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca nazive kolona za Reservation koje zelimo da sacuvamo u
	 * tabeli.
	 * 
	 * @return String koji predstavlja nazive kolona koji ubacujemo u tabelu rezervacija.
	 */
    @Override
    public String getParameterNames() {
        return "ReservationId, NameLastname, Email, UserId, ShowtimeId";
    }

    
    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca vrednost primarnog kljuca za datu rezervaciju.
	 * 
	 * @return int vrednost indentifikatora rezervacije
	 */
    @Override
    public int getPrimaryKeyValue() {
        return reservationId;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca naziv primarnog kljuca za Reserervation.
	 * 
	 * @return String naziv primarnog kljuca za rezervaciju,
	 * u ovom slucaju to je ReservationId.
	 */
    @Override
    public String getPrimaryKeyName() {
        return "ReservationId";
    }

    /**
  	 * Implementirana metoda iz interfejsa DomainObject.
  	 * Metoda koja cita iz ResultSeta listu rezervacija.
  	 * 
  	 * @param rs ResultSet iz kog cemo procitati listu rezervacija.
  	 * @return Lista rezervacija koje su procitani iz baze.
  	 */
    @Override
    public List<DomainObject> convertRSList(ResultSet rs) {
        List<DomainObject> list = new ArrayList<>();
        try {
            while (rs.next()) {
                int reservationId = rs.getInt("ReservationId");
                String nameLastname = rs.getString("NameLastname");
                String email = rs.getString("Email");
                int userId = rs.getInt("UserId");
                int movieYear = rs.getInt("m.Year");
                int showtimeId = rs.getInt("s.ShowtimeId");
                Date showtimeDate = rs.getDate("s.Date");
                Time showtimeTime =rs.getTime("s.Time") ;
                int movieId = rs.getInt("m.MovieId");
                System.out.println("MOVIE ID:"+movieId);
                int movieDuration = rs.getInt("m.DurationInMinutes");
                String movieName = rs.getString("m.Name");

                int hallId = rs.getInt("h.HallId");
                String hallN = rs.getString("h.Name");

                int hallC = rs.getInt("h.Capacity");

                list.add(new Reservation(reservationId, nameLastname, email, new User(userId), new Showtime(showtimeId, showtimeDate, showtimeTime, null, new Hall(hallId, hallN, hallC), new Movie(movieId, movieName, movieYear, movieDuration), null)));
            }
        } catch (Exception ex) {
            System.out.println("ERROR ResultSet " + getTableName());
        }

        return list;
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda koja vraca naziv kolone i vrednost na koju ce ta kolona biti
	 * azurirana u tabeli Reservation.
	 * 
	 * @return String naziv kolone i vrednost na koju ce ta kolona biti postavljena.
	 */
    @Override
    public String getUpdateQuery() {
        return "ReservationId=" + reservationId + ", NameLastname= '" + nameLastname + "', Email='" + email + "', UserId=" + user.getUserId() + ", ShowtimeId=" + showtime.getShowtimeId();
    }

    /*
 	 * Implementirana metoda iz interfejsa DomainObject.
 	 * Metoda vraca uslov za spajanje tabele sa 2. tabelom.
 	 * 
 	 * @return String metoda vraca uslov za spajanje tabele Reservation sa 2. tabelama.
 	 * Kod klase rezervacija je povezivanje sa tabelom Showtime, Movie i Hall.
 	 */
    @Override
    public String getJoinCondition() {
        return "JOIN Showtime s on s.showtimeId=t.showtimeId JOIN Movie m on m.movieId=s.movieId JOIN hall h on h.hallId=s.hallId";
    }
    
    /**
     * Vraca string sa podacima o rezervaciji: 
     * <ol>
     * <li> ime i prezime osobe na koju se vrsi rezervacija <li>ime projekcije</ol>
     * @return String Podaci o rezervaciji u tekstualnom formatu.
     */
    @Override
    public String toString() {
        return nameLastname + " " + showtime.getMovie().getName();
    }

    /**
	 * Implementirana metoda iz interfejsa DomainObject.
	 * Metoda vraca uslov za sortiranje vrednosti za klasu Reservation.
	 * 
	 * @return vraca vrednost po kom ce biti sortirani objekti klase Reservation.
	 */
    @Override
    public String getSortCondition() {
        return null;
    }

}
