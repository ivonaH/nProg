package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Genre;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Hall;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class KreirajRezervacijuTest {
	KreirajRezervaciju kreirajRezervaciju;
	private static Connection connection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String url = "jdbc:mysql://localhost:3306/testBioskop";
		String user = "root";
		String password = "";
		connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		
		DatabaseConnection.getInstance().setUrl("jdbc:mysql://localhost:3306/testBioskop");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//vraca na originalnu bazu
		DatabaseConnection.getInstance().setUrl(Configuration.getInstance().getUrl());
		connection.close();
	}

	@Before
	public void setUp() throws Exception {
		String query = "INSERT INTO user VALUES(1,'ivona','Ivona','Heldrih','ivona123')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (1,'Movie1','adventure','Director 1',2020,120,1)";
		statement.executeUpdate(query);
		
		query="INSERT INTO hall values (1,'Hall1',10)";
		statement.executeUpdate(query);
		
		query="insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,time) VALUES(1,'2020-05-15',1,1,1,'15:00:00')";
		statement.executeUpdate(query);
		
		connection.commit();
        statement.close();

	}
	@After
	public void tearDown() throws Exception {
		kreirajRezervaciju=null;
		
		String query = "Delete from reservation";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		query = "Delete from showtime";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		query = "Delete from movie";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		
		query = "Delete from hall";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		//brisanje usera
		query = "Delete from user";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		connection.commit();
        statement.close();
	}

	
	@Test(expected = Exception.class)
	public void testKreirajRezervacijuNijeInstancaKlase() throws Exception {
		Movie movie=new Movie();
		kreirajRezervaciju=new KreirajRezervaciju(movie);
	}
	
	@Test
	public void testSacuvajUBazi() throws Exception {
		Showtime showtime=new Showtime();
		showtime.setHall(new Hall(1,"Hall1",10));
		showtime.setShowtimeId(1);
		Reservation reservation=new Reservation("Pera Peric", "pera@gmail.com", new User(1), showtime);
		
		kreirajRezervaciju=new KreirajRezervaciju(reservation);
		kreirajRezervaciju.executeOperation();
		
		String querySelect="SELECT * FROM reservation Where ReservationId=1";
		Statement statement = connection.createStatement();
		ResultSet rs=statement.executeQuery(querySelect);
		List<Reservation> list=new ArrayList<>();
		  while (rs.next()) {
			  int reservationId = rs.getInt("ReservationId");
              String nameLastname = rs.getString("NameLastname");
              String email = rs.getString("Email");
              int userId = rs.getInt("UserId");
              int showtimeId = rs.getInt("ShowtimeId");

				list.add(new Reservation(reservationId, nameLastname, email, new User(userId), new Showtime(showtimeId)));

          }

           assertEquals(reservation.getReservationId(), list.get(0).getReservationId());
           assertEquals(reservation.getNameLastname(), list.get(0).getNameLastname());
           assertEquals(reservation.getEmail(), list.get(0).getEmail());
           assertEquals(reservation.getUser().getUserId(), list.get(0).getUser().getUserId());
           assertEquals(reservation.getShowtime().getShowtimeId(), list.get(0).getShowtime().getShowtimeId());

           


}

}
