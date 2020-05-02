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
 *
 * @author Ivona
 */
public class Movie implements DomainObject, Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int movieId;
    private String name;
    private Genre genre;
    private String director;
    private int year;
    private User user;
    private int durationInMinutes;

    public Movie() {
    }

    public Movie(int movieId, String name, Genre genre, String director, int year, int durationInMinutes, User user) {
        this.movieId = movieId;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
        this.user = user;
        this.durationInMinutes = durationInMinutes;
    }

    public Movie(String name, Genre genre, String director, int year, int durationInMinutes, User user) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
        this.user = user;
        this.durationInMinutes = durationInMinutes;
    }

    Movie(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    Movie(int movieId, String movieName, int year, int durationInMinutes) {
        this.movieId = movieId;
        this.name = movieName;
        this.year = year;
        this.durationInMinutes = durationInMinutes;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getTableName() {
        return "Movie";
    }

    @Override
    public String getParameters() {
        return String.format("%s, '%s','%s','%s',%s,%s, %s", movieId, name, genre, director, year, durationInMinutes, user.getUserId());
    }

    @Override
    public String getParameterNames() {
        return "movieId, name, genre, director, year, durationInMinutes, userId";
    }

    @Override
    public int getPrimaryKeyValue() {
        return movieId;
    }

    @Override
    public String getPrimaryKeyName() {
        return "MovieId";
    }

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

    @Override
    public String getUpdateQuery() {
        return "MovieId=" + movieId + ", Name='" + name + "', Genre='" + genre + "', director='" + director + "', Year=" + year + ",DurationInMinutes=" + durationInMinutes + " UserId=" + user.getUserId();
    }

    @Override
    public String toString() {
        return name + " " + year;
    }

    @Override
    public String getJoinCondition() {
        return null;
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

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String getSortCondition() {
        return "year DESC, name ASC";
    }

    
}
