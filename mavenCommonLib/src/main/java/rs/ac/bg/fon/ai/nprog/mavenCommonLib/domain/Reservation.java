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
 *
 * @author Ivona
 */
public class Reservation implements DomainObject, Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reservationId;
    private String nameLastname;
    private String email;
    private User user;
    private Showtime showtime;

    public Reservation() {
    }

    public Reservation(int reservationId, String nameLastname, String email, User user, Showtime showtime) {
        this.reservationId = reservationId;
        this.nameLastname = nameLastname;
        this.email = email;
        this.user = user;
        this.showtime = showtime;
    }
    public Reservation( String nameLastname, String email, User user, Showtime showtime) {
        this.nameLastname = nameLastname;
        this.email = email;
        this.user = user;
        this.showtime = showtime;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getNameLastname() {
        return nameLastname;
    }

    public void setNameLastname(String nameLastname) {
        this.nameLastname = nameLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    @Override
    public String getTableName() {
        return "Reservation";
    }

    @Override
    public String getParameters() {
        return String.format("%s, '%s','%s', %s, %s", reservationId, nameLastname, email, user.getUserId(), showtime.getShowtimeId());
    }

    @Override
    public String getParameterNames() {
        return "ReservationId, NameLastname, Email, UserId, ShowtimeId";
    }

    @Override
    public int getPrimaryKeyValue() {
        return reservationId;
    }

    @Override
    public String getPrimaryKeyName() {
        return "ReservationId";
    }

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

    @Override
    public String getUpdateQuery() {
        return "ReservationId=" + reservationId + ", NameLastname= '" + nameLastname + "', Email='" + email + ", UserId=" + user.getUserId() + ", ShowtimeId=" + showtime.getShowtimeId();
    }

    @Override
    public String getJoinCondition() {
        return "JOIN Showtime s on s.showtimeId=t.showtimeId JOIN Movie m on m.movieId=s.movieId JOIN hall h on h.hallId=s.hallId";
    }

    @Override
    public String toString() {
        return nameLastname + " " + showtime.getMovie().getName();
    }

    @Override
    public String getSortCondition() {
        return null;
    }

}
