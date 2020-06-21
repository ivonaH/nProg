package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Genre;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Hall;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class IzmeniProjekcijuTest {
	IzmeniProjekciju izmeniProjekciju;
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
		String query = "INSERT INTO user VALUES(1,'ivona','Ivona','Heldrih','ivona123')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		query = "INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (1,'Movie1','adventure','Director 1',2020,120,1)";
		statement.executeUpdate(query);

		query = "INSERT INTO user VALUES(2,'pera','Pera','Peric','pera123')";
		statement.executeUpdate(query);

		query = "INSERT INTO hall values (1,'Hall1',10)";
		statement.executeUpdate(query);

		query = "INSERT INTO hall values (2,'Hall2',2)";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,time) VALUES(1,'2020-05-15',1,1,1,'15:00:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,time) VALUES(2,'2020-05-15',1,2,1,'14:00:00')";
		statement.executeUpdate(query);

		connection.commit();
		statement.close();

	}

	@After
	public void tearDown() throws Exception {
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

		// brisanje usera
		query = "Delete from user";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		connection.commit();
		statement.close();
	}

	@Test(expected = Exception.class)
	public void testIzmeniProjekcijuNijeInstancaKlase() throws Exception {
		Movie movie = new Movie();
		izmeniProjekciju = new IzmeniProjekciju(movie);
	}

	@Test
	public void testIzmeniProjekcijuUspesnoIzmenjenDatumVremeKorisnik() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Hall hall = new Hall();
		hall.setHallId(1);
		hall.setCapacity(10);
		Movie movie = new Movie();
		movie.setMovieId(1);

		Showtime showtime = new Showtime(sdf.parse("2020-05-16"), stf.parse("16:00:00"), new User(2), hall, movie);
		showtime.setShowtimeId(1);

		izmeniProjekciju = new IzmeniProjekciju(showtime);
		izmeniProjekciju.executeOperation();

		String querySelect = "SELECT * FROM showtime Where showtimeId=1";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(querySelect);
		List<Showtime> list = new ArrayList<>();

		while (rs.next()) {
			int showtimeId = rs.getInt("ShowtimeId");
			Date date = rs.getDate("Date");
			Date time = rs.getTime("Time");
			int userId = rs.getInt("UserId");
			int hallId = rs.getInt("HallId");
			int movieId = rs.getInt("MovieId");
			int movieMarathonId = rs.getInt("MovieMarathonId");
			Hall h = new Hall();
			h.setHallId(hallId);
			Movie m = new Movie();
			m.setMovieId(movieId);
			list.add(new Showtime(showtimeId, date, time, new User(userId), h, m, new MovieMarathon(movieMarathonId)));
		}

		assertEquals(list.get(0), showtime);

	}

	@Test(expected = ValidationException.class)
	public void testIzmeniProjekcijuNeuspesnoIzmenjenaSalaZbogKapacitetaSale() throws Exception {

		Statement statement = connection.createStatement();
		String query = "INSERT into reservation values (1,'Pera Peric','pera@gmail.com',1,1)";
		statement.executeUpdate(query);
		query = "INSERT into reservation values (2,'Ana Anic','ana@gmail.com',1,1)";
		statement.executeUpdate(query);
		query = "INSERT into reservation values (3,'Jana Janic','ana@gmail.com',1,1)";
		statement.executeUpdate(query);
		connection.commit();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Hall hall = new Hall();
		hall.setHallId(2);
		hall.setCapacity(2);
		hall.setName("Hall2");
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setName("Movie1");
		movie.setGenre(Genre.adventure);
		movie.setDurationInMinutes(120);

		Showtime showtime = new Showtime(sdf.parse("2020-05-15"), stf.parse("15:00:00"), new User(1), hall, movie);
		showtime.setShowtimeId(1);

		izmeniProjekciju = new IzmeniProjekciju(showtime);
		izmeniProjekciju.executeOperation();

	}

	@Test(expected = ValidationException.class)
	public void testIzmeniProjekcijuNespesnoIzmenjenaSalaZauzetaUTomTerminu() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Hall hall = new Hall();
		hall.setHallId(2);
		hall.setCapacity(2);
		hall.setName("Hall2");
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setName("Movie1");
		movie.setGenre(Genre.adventure);
		movie.setDurationInMinutes(120);

		Showtime showtime = new Showtime(sdf.parse("2020-05-15"), stf.parse("15:00:00"), new User(1), hall, movie);
		showtime.setShowtimeId(1);


		izmeniProjekciju = new IzmeniProjekciju(showtime);
		izmeniProjekciju.executeOperation();

		

	}
}
