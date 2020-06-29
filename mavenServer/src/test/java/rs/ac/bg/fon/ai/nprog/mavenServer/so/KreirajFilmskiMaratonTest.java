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

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Hall;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class KreirajFilmskiMaratonTest {
	KreirajFilmskiMaraton kreirajFilmskiMarton;

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

		query = "INSERT INTO user values(2,'pera','Pera','Peric','pera123')";
		statement.executeUpdate(query);

		query = "INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (1,'Movie1','adventure','Director 1',2020,55,1)";
		statement.executeUpdate(query);

		query = "INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (2,'Movie2','adventure','Director 2',2020,50,1)";
		statement.executeUpdate(query);

		query = "INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (3,'Movie3','adventure','Director 3',2020,120,1)";
		statement.executeUpdate(query);

		query = "INSERT INTO hall values (1,'Hall1',10)";
		statement.executeUpdate(query);

		query = "INSERT INTO hall values (2,'Hall2',20)";
		statement.executeUpdate(query);

		query = "INSERT INTO hall values (3,'Hall3',30)";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,time) VALUES(1,'2020-05-15',1,1,1,'15:00:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,time) VALUES(2,'2020-05-15',1,2,2,'16:00:00')";
		statement.executeUpdate(query);

		connection.commit();
		statement.close();

	}

	@After
	public void tearDown() throws Exception {

		kreirajFilmskiMarton = null;

		String query = "Delete from showtime";
		Statement statement = connection.createStatement();
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

	@Test(expected = Exception.class)
	public void testKreirajFilmskiMaratonNijeInstancaKlase() throws Exception {
		Movie movie = new Movie();
		kreirajFilmskiMarton = new KreirajFilmskiMaraton(movie);
	}

	@Test
	public void testKreirajFilmskiMaraton() throws Exception {
		MovieMarathon movieMarathon = new MovieMarathon("Marathon1", new User(1));
		List<Showtime> showtimes = new ArrayList<>();
		Showtime showtime1=new Showtime(1);
		showtime1.setHall(new Hall(1,"Hall1",10));
		showtimes.add(showtime1);
		Showtime showtime2=new Showtime(2);
		showtime2.setHall(new Hall(2,"Hall2",20));
		showtimes.add(showtime1);
		showtimes.add(showtime2);

		ArrayList<Object> objects = new ArrayList<>();
		objects.add(movieMarathon);
		objects.add(showtimes);

		kreirajFilmskiMarton = new KreirajFilmskiMaraton((Object)objects);
		kreirajFilmskiMarton.executeOperation();

		List<MovieMarathon> marathons = new ArrayList<>();
		marathons.add(movieMarathon);

		String query = "SELECT * from movieMarathon where marathonId=1";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		List<MovieMarathon> list = new ArrayList<>();
		while (rs.next()) {
			int marathonId = rs.getInt("MarathonId");
			String name = rs.getString("Name");
			int id = rs.getInt("UserId");

			list.add(new MovieMarathon(marathonId, name, new User(id)));

		}
		assertEquals(list,marathons);
		
		//provera da li je izmenjen id za maraton kod projekcija
		
		List<Showtime> showtimesDb = new ArrayList<>();
		query="Select * from showtime where moviemarathonid=1";
		ResultSet res=statement.executeQuery(query);
		while (res.next()) {
			int showtimeId = res.getInt("ShowtimeId");
			
			int movieMarathonId = res.getInt("MovieMarathonId");
			
			Showtime sh=new Showtime(showtimeId);
			sh.setMovieMarathon(movieMarathon);
			showtimesDb.add(sh);
		}
		assertTrue(showtimesDb.size()==2);
		assertTrue(showtimesDb.get(0).getShowtimeId()==1);
		assertTrue(showtimesDb.get(0).getMovieMarathon().getMarathonId()==1);
		assertTrue(showtimesDb.get(1).getShowtimeId()==2);
		assertTrue(showtimesDb.get(0).getMovieMarathon().getMarathonId()==1);



	}

}
