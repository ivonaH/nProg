/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Klasa Showtime predstvalja projekciju sa svim svojim atributima. Implementira
 * interfejs DomainObject i Serializable.
 *
 * @author Ivona
 * 
 * @version 1.0
 */
public class Showtime implements DomainObject, Serializable {

	/**
	 * indentifikator projekcije
	 */
	private int showtimeId;
	/**
	 * datum projekcije
	 */
	private Date date;
	/**
	 * vreme projekcije
	 */
	private Date time;
	/**
	 * korisnik koji je uneo projekciju
	 */
	private User user;
	/**
	 * sala u kojoj se odrzava projekcija
	 */
	private Hall hall;
	/**
	 * film koji se prikazuje na projekciji
	 */
	private Movie movie;
	/**
	 * filmski maraton na kom se prikazuje projekcija
	 */
	private MovieMarathon movieMarathon;

	/**
	 * Parametrizovani konstruktor za projekciju.
	 * 
	 * @param showtimeId    indentifikator projekcije
	 * @param date          datum projekcije
	 * @param time          vreme projekcije
	 * @param user          korisnik koji je uneo projekciju
	 * @param hall          sala u kojoj je projekcija
	 * @param movie         film koji se prikazuje u projekciji
	 * @param movieMarathon filmski maraton na kom se prikazuje projekcija
	 */
	public Showtime(int showtimeId, Date date, Date time, User user, Hall hall, Movie movie,
			MovieMarathon movieMarathon) {
		this.showtimeId = showtimeId;
		this.date = date;
		this.time = time;
		this.user = user;
		this.hall = hall;
		this.movie = movie;
		this.movieMarathon = movieMarathon;
	}

	/**
	 * Parametrizovani konstruktor za projekciju.
	 * 
	 * @param date  datum projekcije
	 * @param time  vreme projekcije
	 * @param user  korisnik koji je uneo projekciju
	 * @param hall  sala u kojoj je projekcija
	 * @param movie film koji se prikazuje u projekciji
	 */
	public Showtime(Date date, Date time, User user, Hall hall, Movie movie) {
		this.date = date;
		this.time = time;
		this.user = user;
		this.hall = hall;
		this.movie = movie;
	}

	/**
	 * Neparametrizovani konstruktor za projekciju.
	 */
	public Showtime() {
	}

	/**
	 * Parametrizovani konstruktor za projekciju.
	 * 
	 * @param showtimeId indentifikator projekcije
	 */
	Showtime(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	/**
	 * get metoda za showtimeId.
	 * 
	 * @return indentifikator projekcije
	 */
	public int getShowtimeId() {
		return showtimeId;
	}

	/**
	 * set metoda za showtimeId.
	 * 
	 * @param indentifikator projekcije
	 */
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	/**
	 * get metoda za datum projekcije
	 * 
	 * @return datum projekcije
	 */
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * get metoda za vreme projekcije
	 * 
	 * @return vreme projekcije
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Set metoda za vreme projekcije.
	 * 
	 * @param vreme projekcije
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * Get metoda za korisnika.
	 * 
	 * @return korisnik koji je uneo projekciju
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set metoda za korisnika.
	 * 
	 * @param korisnik koji je uneo projekciju
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Get metoda za salu.
	 * 
	 * @return <b>hall</b> sala u kojoj se odrzava projekcija
	 */
	public Hall getHall() {
		return hall;
	}

	/**
	 * Set metoda za salu.
	 * 
	 * @param sala u kojoj se odrzava projekcija
	 */
	public void setHall(Hall hall) {
		this.hall = hall;
	}

	/**
	 * Get metoda za film koji se prikazuje na projekciji.
	 * 
	 * @return film koji se prikazuje na projekciji
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * Set metoda za film.
	 * 
	 * @param film koji se prikazuje na projekciji
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * Get metoda za filmski maraton.
	 * 
	 * @return filmski maraton na kom se prikazuje projekcija
	 */
	public MovieMarathon getMovieMarathon() {
		return movieMarathon;
	}

	/**
	 * Set metoda za filmski maraton.
	 * 
	 * @param maraton na kom se prikazuje projekcija
	 */
	public void setMovieMarathon(MovieMarathon movieMarathon) {
		this.movieMarathon = movieMarathon;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca naziv tabele
	 * za domenski objekat Showtime.
	 * 
	 * @return String koji predstavlja naziv tabele, u ovom slucaju "Showtime".
	 */
	@Override
	public String getTableName() {
		return "Showtime";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca vrednosti za
	 * rezervaciju koje zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja vrednosti (za rezervaciju) koje ubacujemo u
	 *         tabelu; u ovom slucaju to su indentifikator projekcije, datum, vreme,
	 *         id korisnika, id sale i id filma.
	 */
	@Override
	public String getParameters() {
		return String.format("%s, '%s','%s',%s,%s,%s", showtimeId, new java.sql.Date(date.getTime()),
				new java.sql.Time(time.getTime()), user.getUserId(), hall.getHallId(), movie.getMovieId());
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca nazive kolona
	 * za Showtime koje zelimo da sacuvamo u tabeli.
	 * 
	 * @return String koji predstavlja nazive kolona koji ubacujemo u tabelu
	 *         projekcija.
	 */
	@Override
	public String getParameterNames() {
		return "ShowtimeId, Date, Time, UserId, HallId, MovieId";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca vrednost
	 * primarnog kljuca za datu projekciju.
	 * 
	 * @return int vrednost indentifikatora projekcije
	 */
	@Override
	public int getPrimaryKeyValue() {
		return showtimeId;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca naziv
	 * primarnog kljuca za Showtime.
	 * 
	 * @return String naziv primarnog kljuca za projekciju, u ovom slucaju to je
	 *         ShowtimeId.
	 */
	@Override
	public String getPrimaryKeyName() {
		return "ShowtimeId";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda koja cita iz
	 * ResultSeta listu projekcija.
	 * 
	 * @param rs ResultSet iz kog cemo procitati listu projekciju.
	 * @return Lista projekcija koje su procitani iz baze.
	 */
	@Override
	public List<DomainObject> convertRSList(ResultSet rs) {
		List<DomainObject> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int showtimeId = rs.getInt("ShowtimeId");
				Date date = rs.getDate("Date");
				Date time = rs.getTime("Time");
				int userId = rs.getInt("UserId");
				int hallId = rs.getInt("HallId");
				int movieId = rs.getInt("t.MovieId");
				String movieName = rs.getString("m.Name");
				int movieMarathonId = rs.getInt("MovieMarathonId");
				int movieDuration = rs.getInt("m.DurationInMinutes");
				int movieYear = rs.getInt("m.Year");
				int capacity = rs.getInt("h.Capacity");
				String hallName = rs.getString("h.Name");
				list.add(new Showtime(showtimeId, date, time, new User(userId), new Hall(hallId, hallName, capacity),
						new Movie(movieId, movieName, movieYear, movieDuration), new MovieMarathon(movieMarathonId)));
			}
		} catch (Exception ex) {
			System.out.println("ERROR ResultSet " + getTableName());
		}

		return list;
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda koja vraca naziv
	 * kolone i vrednost na koju ce ta kolona biti azurirana u tabeli Showtime.
	 * 
	 * @return String naziv kolone i vrednost na koju ce ta kolona biti postavljena.
	 */
	@Override
	public String getUpdateQuery() {
		return " hallId=" + hall.getHallId();
	}

	/**
	 * Vraca string sa podacima o projekciji:
	 * <ol>
	 * <li>vreme projekcije
	 * <li>sala u kojoj je projekcija
	 * </ol>
	 * 
	 * @return String Podaci o rezervaciji u tekstualnom formatu.
	 */
	@Override
	public String toString() {
		return time + " " + hall.getName();
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca uslov za
	 * spajanje tabele sa 2. tabelom.
	 * 
	 * @return String metoda vraca uslov za spajanje tabele Showtime sa 2. tabelama.
	 *         U ovom slucaju to su Hall i Movie.
	 */
	@Override
	public String getJoinCondition() {
		return " JOIN Hall h on h.Hallid=t.HallId JOIN Movie m on t.movieId=m.movieId";
	}

	/**
	 * Implementirana metoda iz interfejsa DomainObject. Metoda vraca uslov za
	 * sortiranje vrednosti za klasu Showtime.
	 * 
	 * @return vraca vrednost po kom ce biti sortirani objekti klase Showtime. U
	 *         ovom slucaju to je po vremenu projekcije rastuce.
	 */
	@Override
	public String getSortCondition() {
		return " time asc";
	}

}
