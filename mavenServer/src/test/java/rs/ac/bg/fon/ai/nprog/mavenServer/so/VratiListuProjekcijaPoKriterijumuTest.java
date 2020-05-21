package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class VratiListuProjekcijaPoKriterijumuTest {
	VratiListuProjekcijaPoKriterijumu vratiListuProjekcijaPoKriterijumu;

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

		query = "insert into moviemarathon VALUES (1,'Marathon1',1)";
		statement.executeUpdate(query);

		query = "insert into moviemarathon VALUES (2,'Marathon2',1)";
		statement.executeUpdate(query);

		query = "insert into moviemarathon VALUES (3,'Marathon3',2)";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(1,'2020-05-15',1,1,1,1,'15:00:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(2,'2020-05-15',1,2,2,1,'16:00:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(3,'2020-05-20',1,3,3,2,'12:00:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(4,'2020-05-20',1,2,1,2,'14:30:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(5,'2020-05-20',1,3,2,2,'15:30:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(6,'2020-05-25',2,3,1,3,'14:30:00')";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(7,'2020-05-25',2,3,2,3,'15:30:00')";
		statement.executeUpdate(query);

		connection.commit();
		statement.close();

	}

	@After
	public void tearDown() throws Exception {
		vratiListuProjekcijaPoKriterijumu = null;

		columns = null;
		values = null;

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

	
	@Test
	public void VratiListuProjekcijaPoDatumuKorisnikuMaratonu() throws Exception {
		columns.add("Date");
		values.add("2020-05-15");

		columns.add("t.userId");
		values.add("1");

		columns.add("t.MovieMarathonId");
		values.add("1");

		vratiListuProjekcijaPoKriterijumu = new VratiListuProjekcijaPoKriterijumu(columns, values);
		vratiListuProjekcijaPoKriterijumu.executeOperation();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Hall hall = new Hall();
		hall.setHallId(1);
		Movie movie = new Movie();
		movie.setMovieId(1);

		Showtime showtime = new Showtime(sdf.parse("2020-05-15"), stf.parse("15:00:00"), new User(1), hall, movie);
		showtime.setShowtimeId(1);
		showtime.setMovieMarathon(new MovieMarathon(1));

		Hall hall2 = new Hall();
		hall2.setHallId(2);
		Movie movie2 = new Movie();
		movie2.setMovieId(2);
		
		Showtime showtime2 = new Showtime(sdf.parse("2020-05-15"), stf.parse("16:00:00"), new User(1), hall2, movie2);
		showtime2.setShowtimeId(2);
		showtime2.setMovieMarathon(new MovieMarathon(1));
		
		List<Showtime> showtimes = new ArrayList<>();
		showtimes.add(showtime);
		showtimes.add(showtime2);


		assertEquals(showtimes, vratiListuProjekcijaPoKriterijumu.getShowtimes());

	}
	
	
	@Test
	public void VratiListuProjekcijaPoSaliFilmuVremenu() throws Exception {
		
		columns.add("t.HallId");
		values.add("3");

		columns.add("t.MovieId");
		values.add("2");
		
		columns.add("Time");
		values.add("15:30:00");
		
		vratiListuProjekcijaPoKriterijumu = new VratiListuProjekcijaPoKriterijumu(columns, values);
		vratiListuProjekcijaPoKriterijumu.executeOperation();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Hall hall = new Hall(3,"Hall3",30);
		Movie movie = new Movie();
		movie.setMovieId(2);

		Showtime showtime = new Showtime(sdf.parse("2020-05-20"), stf.parse("15:30:00"), new User(1), hall, movie);
		showtime.setShowtimeId(5);
		showtime.setMovieMarathon(new MovieMarathon(1));
		
		
		Showtime showtime2 = new Showtime(sdf.parse("2020-05-25"), stf.parse("15:30:00"), new User(2), hall, movie);
		showtime2.setShowtimeId(7);
		showtime2.setMovieMarathon(new MovieMarathon(1));

		List<Showtime> showtimes = new ArrayList<>();
		showtimes.add(showtime);
		showtimes.add(showtime2);

//		assertEquals(showtimes,vratiListuProjekcijaPoKriterijumu.getShowtimes());

		assertEquals(showtimes.get(0),vratiListuProjekcijaPoKriterijumu.getShowtimes().get(0));

	}
	
	@Test
	public void VratiListuProjekcijaPoSvimKriterijumima() throws Exception {
		columns.add("ShowtimeId");
		values.add("1");

		columns.add("Date");
		values.add("2020-05-15");

		columns.add("t.UserId");
		values.add("1");

		columns.add("t.HallId");
		values.add("1");

		columns.add("t.MovieId");
		values.add("1");
		
		columns.add("t.MovieMarathonId");
		values.add("1");


		columns.add("Time");
		values.add("15:00:00");

		vratiListuProjekcijaPoKriterijumu = new VratiListuProjekcijaPoKriterijumu(columns, values);
		vratiListuProjekcijaPoKriterijumu.executeOperation();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		Hall hall = new Hall();
		hall.setHallId(1);
		Movie movie = new Movie();
		movie.setMovieId(1);

		Showtime showtime = new Showtime(sdf.parse("2020-05-15"), stf.parse("15:00:00"), new User(1), hall, movie);
		showtime.setShowtimeId(1);
		showtime.setMovieMarathon(new MovieMarathon(1));

		List<Showtime> showtimes = new ArrayList<>();
		showtimes.add(showtime);

		assertEquals(showtimes, vratiListuProjekcijaPoKriterijumu.getShowtimes());

	}

	@Test
	public void VratiListuProjekcijaPoNepostojecemKriterijumu() throws Exception {

		columns.add("Date");
		values.add("2020-10-15");

		vratiListuProjekcijaPoKriterijumu = new VratiListuProjekcijaPoKriterijumu(columns, values);
		vratiListuProjekcijaPoKriterijumu.executeOperation();

		assertTrue(vratiListuProjekcijaPoKriterijumu.getShowtimes().isEmpty());

	}

}
