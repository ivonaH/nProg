package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Genre;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class VratiProjekcijuSaIdTest {
	private static Connection connection;
	VratiProjekcijuSaId vratiProjekcijuSaId;
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

		query = "INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (1,'Movie1','adventure','Director 1',2020,55,1)";
		statement.executeUpdate(query);

		query = "INSERT INTO hall values (1,'Hall1',10)";
		statement.executeUpdate(query);


		query = "insert into moviemarathon VALUES (1,'Marathon1',1)";
		statement.executeUpdate(query);

		query = "insert into showtime(ShowtimeId,Date,UserId,HallId,MovieId,MovieMarathonId,time) VALUES(1,'2020-05-15',1,1,1,1,'15:00:00')";
		statement.executeUpdate(query);

	

		connection.commit();
		statement.close();

	}

	@After
	public void tearDown() throws Exception {
		vratiProjekcijuSaId=null;
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
	public void testVratiProjekcijuSaIdTest() throws Exception {

		vratiProjekcijuSaId=new VratiProjekcijuSaId(1);
		vratiProjekcijuSaId.executeOperation();
		Showtime showtime = vratiProjekcijuSaId.getShowtime();

		assertEquals(new Showtime(1), showtime);
	}

	@Test
	public void testVratiProjekcijuSaIdNepostojeciTest() throws Exception {

		vratiProjekcijuSaId = new VratiProjekcijuSaId(100);
		vratiProjekcijuSaId.executeOperation();
		Showtime showtime = vratiProjekcijuSaId.getShowtime();

		assertEquals(showtime, null);
	}

}
