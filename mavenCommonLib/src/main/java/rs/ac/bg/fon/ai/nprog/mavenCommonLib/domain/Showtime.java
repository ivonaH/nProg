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
 *
 * @author Ivona
 */
public class Showtime implements DomainObject, Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int showtimeId;
    private Date date;
    private Date time;
    private User user;
    private Hall hall;
    private Movie movie;
    private MovieMarathon movieMarathon;

    public Showtime(int showtimeId, Date date, Date time, User user, Hall hall, Movie movie, MovieMarathon movieMarathon) {
        this.showtimeId = showtimeId;
        this.date = date;
        this.time = time;
        this.user = user;
        this.hall = hall;
        this.movie = movie;
        this.movieMarathon = movieMarathon;
    }
    public Showtime( Date date, Date time, User user, Hall hall, Movie movie) {
        this.date = date;
        this.time = time;
        this.user = user;
        this.hall = hall;
        this.movie = movie;
    }

    public Showtime() {
    }

    Showtime(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieMarathon getMovieMarathon() {
        return movieMarathon;
    }

    public void setMovieMarathon(MovieMarathon movieMarathon) {
        this.movieMarathon = movieMarathon;
    }

    @Override
    public String getTableName() {
        return "Showtime";
    }

    @Override
    public String getParameters() {
        return String.format("%s, '%s','%s',%s,%s,%s", showtimeId, new java.sql.Date(date.getTime()), new java.sql.Time(time.getTime()), user.getUserId(), hall.getHallId(), movie.getMovieId());
    }

    @Override
    public String getParameterNames() {
        return "ShowtimeId, Date, Time, UserId, HallId, MovieId";
    }

    @Override
    public int getPrimaryKeyValue() {
        return showtimeId;
    }

    @Override
    public String getPrimaryKeyName() {
        return "ShowtimeId";
    }

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
                String movieName=rs.getString("m.Name");
                int movieMarathonId = rs.getInt("MovieMarathonId");
                int movieDuration=rs.getInt("m.DurationInMinutes");
                int movieYear=rs.getInt("m.Year");
                int capacity = rs.getInt("h.Capacity");
                String hallName = rs.getString("h.Name");
                list.add(new Showtime(showtimeId, date, time, new User(userId), new Hall(hallId, hallName, capacity), new Movie(movieId,movieName,movieYear,movieDuration), new MovieMarathon(movieMarathonId)));
            }
        } catch (Exception ex) {
            System.out.println("ERROR ResultSet " + getTableName());
        }

        return list;
    }

    @Override
    public String getUpdateQuery() {
        return " hallId=" + hall.getHallId();
    }

    @Override
    public String toString() {
        return time+" "+hall.getName();
    }

    @Override
    public String getJoinCondition() {
        return " JOIN Hall h on h.Hallid=t.HallId JOIN Movie m on t.movieId=m.movieId";
    }

    @Override
    public String getSortCondition() {
        return " time asc";
    }


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
        return true;
    }

    
    
}
