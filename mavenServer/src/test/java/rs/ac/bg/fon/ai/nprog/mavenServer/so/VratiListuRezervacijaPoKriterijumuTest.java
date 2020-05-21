package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Genre;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class VratiListuRezervacijaPoKriterijumuTest {

	VratiListuRezervacijaPoKriterijumu vratiListuRezervacijaPoKriterijumu;

	List<String> columns;
	List<String> values;

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
		// vraca na originalnu bazu
		DatabaseConnection.getInstance().setUrl(Configuration.getInstance().getUrl());
		connection.close();
	}

	@Before
	public void setUp() throws Exception {
		columns = new ArrayList<>();
		values = new ArrayList<>();

		String query = "INSERT INTO user VALUES(1,'ivona','Ivona','Heldrih','ivona123')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		query = "INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (1,'Movie1','adventure','Director 1',2020,120,1)";
		statement.executeUpdate(query);

		query = "INSERT INTO hall values (1,'Hall1',1)";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,time) VALUES(1,'2020-05-15',1,1,1,'15:00:00')";
		statement.executeUpdate(query);

		query = "INSERT into reservation values (1,'Ivona Ivonic','ivona@gmail.com',1,1)";
		statement.executeUpdate(query);

		query = "INSERT into reservation values (2,'Ana Anic','ana@gmail.com',1,1)";
		statement.executeUpdate(query);

		query = "INSERT into reservation values (3,'Kaca Kacic','kaca@gmail.com',1,1)";
		statement.executeUpdate(query);

		connection.commit();
		statement.close();

	}

	@After
	public void tearDown() throws Exception {
		vratiListuRezervacijaPoKriterijumu = null;

		columns = null;
		values = null;

		String query = "Delete from reservation";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		query = "Delete from showtime";
		statement.executeUpdate(query);

		query = "Delete from movieMarathon";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		query = "Delete from movie";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		query = "Delete from hall";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		// brisanje usera
		query = "Delete from user";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		connection.commit();
		statement.close();
	}
	
	@Test
	public void VratiListuRezervacijaPoUseru() throws Exception {
	

		columns.add("t.UserId");
		values.add("1");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		Movie movie = new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1));

		Showtime showtime = new Showtime(1);
		showtime.setMovie(movie);

		Reservation reservation = new Reservation(1, "Ivona Ivonic", "ivona@gmail.com", new User(1), showtime);
		List<Reservation> reservations=new ArrayList<>();
		reservations.add(reservation);
		reservations.add(new Reservation(2,"Ana Anic","ana@gmail.com",new User(1), showtime));
		reservations.add(new Reservation(3,"Kaca Kacic","kaca@gmail.com",new User(1), showtime));

		
		assertEquals(vratiListuRezervacijaPoKriterijumu.getReservations(),reservations);
	}

	@Test
	public void VratiListuRezervacijaPoProjekciji() throws Exception {
	
		columns.add("t.ShowtimeId");
		values.add("1");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		Movie movie = new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1));

		Showtime showtime = new Showtime(1);
		showtime.setMovie(movie);

		Reservation reservation = new Reservation(1, "Ivona Ivonic", "ivona@gmail.com", new User(1), showtime);
		List<Reservation> reservations=new ArrayList<>();
		reservations.add(reservation);
		reservations.add(new Reservation(2,"Ana Anic","ana@gmail.com",new User(1), showtime));
		reservations.add(new Reservation(3,"Kaca Kacic","kaca@gmail.com",new User(1), showtime));

		
		assertEquals(vratiListuRezervacijaPoKriterijumu.getReservations(),reservations);
	}

	@Test
	public void VratiListuRezervacijaPoEmailu() throws Exception {
	
		columns.add("email");
		values.add("ana@gmail.com");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		Movie movie = new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1));

		Showtime showtime = new Showtime(1);
		showtime.setMovie(movie);

		List<Reservation> reservations=new ArrayList<>();
		reservations.add(new Reservation(2,"Ana Anic","ana@gmail.com",new User(1), showtime));
		
		assertEquals(vratiListuRezervacijaPoKriterijumu.getReservations(),reservations);
	}
	
	@Test
	public void VratiListuRezervacijaPoImenuIPrezimenu() throws Exception {
	
		columns.add("nameLastname");
		values.add("Kaca Kacic");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		Movie movie = new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1));

		Showtime showtime = new Showtime(1);
		showtime.setMovie(movie);

		List<Reservation> reservations=new ArrayList<>();
		reservations.add(new Reservation(3,"Kaca Kacic","kaca@gmail.com",new User(1), showtime));

		
		assertEquals(vratiListuRezervacijaPoKriterijumu.getReservations(),reservations);
	}
	
	@Test
	public void VratiListuRezervacijaPoIdiju() throws Exception {
	
		columns.add("reservationId");
		values.add("3");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		Movie movie = new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1));

		Showtime showtime = new Showtime(1);
		showtime.setMovie(movie);

		List<Reservation> reservations=new ArrayList<>();
		reservations.add(new Reservation(3,"Kaca Kacic","kaca@gmail.com",new User(1), showtime));

		
		assertEquals(vratiListuRezervacijaPoKriterijumu.getReservations(),reservations);
	}
	@Test
	public void VratiListuRezervacijaPoUseruIProjekciji() throws Exception {
	

		columns.add("t.UserId");
		values.add("1");

		columns.add("t.ShowtimeId");
		values.add("1");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		Movie movie = new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1));

		Showtime showtime = new Showtime(1);
		showtime.setMovie(movie);

		Reservation reservation = new Reservation(1, "Ivona Ivonic", "ivona@gmail.com", new User(1), showtime);
		List<Reservation> reservations=new ArrayList<>();
		reservations.add(reservation);
		reservations.add(new Reservation(2,"Ana Anic","ana@gmail.com",new User(1), showtime));
		reservations.add(new Reservation(3,"Kaca Kacic","kaca@gmail.com",new User(1), showtime));

		
		assertEquals(vratiListuRezervacijaPoKriterijumu.getReservations(),reservations);
	}

	@Test
	public void VratiListuRezervacijaPoSvimKriterijumima() throws Exception {
		columns.add("ReservationId");
		values.add("1");

		columns.add("NameLastname");
		values.add("Ivona Ivonic");

		columns.add("Email");
		values.add("ivona@gmail.com");

		columns.add("Email");
		values.add("ivona@gmail.com");

		columns.add("t.UserId");
		values.add("1");

		columns.add("t.ShowtimeId");
		values.add("1");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		Movie movie = new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1));

		Showtime showtime = new Showtime(1);
		showtime.setMovie(movie);

		Reservation reservation = new Reservation(1, "Ivona Ivonic", "ivona@gmail.com", new User(1), showtime);
		List<Reservation> reservations=new ArrayList<>();
		reservations.add(reservation);
		
		
		assertEquals(vratiListuRezervacijaPoKriterijumu.getReservations(),reservations);
	}

	@Test
	public void VratiListuRezervacijaPoNepostojecemKriterijumu() throws Exception {
		columns.add("ReservationId");
		values.add("2022");

		vratiListuRezervacijaPoKriterijumu = new VratiListuRezervacijaPoKriterijumu(columns, values);
		vratiListuRezervacijaPoKriterijumu.executeOperation();

		assertTrue(vratiListuRezervacijaPoKriterijumu.getReservations().isEmpty());
	}

}
