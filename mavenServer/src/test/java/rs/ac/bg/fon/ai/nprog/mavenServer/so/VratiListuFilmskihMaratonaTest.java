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
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class VratiListuFilmskihMaratonaTest {
VratiListuFilmskihMaratona vratiListuFilmskihMaratona;
	
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
		vratiListuFilmskihMaratona=new VratiListuFilmskihMaratona();
		
		String query = "INSERT INTO user VALUES(1,'ivona','Ivona','Heldrih','ivona123')";
		Statement statement = connection.createStatement();
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
		
		query="insert into moviemarathon VALUES (1,'Marathon1',1)";
		statement.executeUpdate(query);

		query="insert into moviemarathon VALUES (2,'Marathon2',1)";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(1,'2020-05-15',1,1,1,1,'15:00:00')";
		statement.executeUpdate(query);
		
		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(2,'2020-05-15',1,2,2,1,'16:00:00')";
		statement.executeUpdate(query);
		
		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(3,'2020-05-20',1,3,3,2,'12:00:00')";
		statement.executeUpdate(query);
		
		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(4,'2020-05-20',1,2,1,2,'14:30:00')";
		statement.executeUpdate(query);
		
		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(5,'2020-05-20',1,1,2,2,'15:30:00')";
		statement.executeUpdate(query);
		
		
		
		connection.commit();
		statement.close();

	}

	@After
	public void tearDown() throws Exception {
		vratiListuFilmskihMaratona= null;

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
	public void VratiListuFilmskihMaratonaTest() throws Exception {
		vratiListuFilmskihMaratona.executeOperation();
		
		List<MovieMarathon> marathonsDb=vratiListuFilmskihMaratona.getMovieMarathons();
		List<MovieMarathon> marathons=new ArrayList<>();

		marathons.add(new MovieMarathon(1,"Marathon2",new User(1)));
		marathons.add(new MovieMarathon(2,"Marathon2",new User(1)));
		

		
		assertEquals(marathons,marathonsDb);
	}

}
