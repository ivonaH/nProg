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
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class VratiFilmSaIdTest {
	VratiFilmSaId vratiFilmSaId;

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

		connection.commit();
		statement.close();

	}

	@After
	public void tearDown() throws Exception {
		vratiFilmSaId = null;

		String query = "Delete from movie";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);

		// brisanje usera
		query = "Delete from user";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		connection.commit();
		statement.close();
	}

	@Test
	public void testVratiFilmSaIdTest() throws Exception {

		vratiFilmSaId = new VratiFilmSaId(1);
		vratiFilmSaId.executeOperation();
		Movie movie = vratiFilmSaId.getMovie();

		assertEquals(new Movie(1, "Movie1", Genre.adventure, "Director 1", 2020, 120, new User(1)), movie);
	}

	@Test
	public void testVratiFilmSaIdNepostojeciTest() throws Exception {

		vratiFilmSaId = new VratiFilmSaId(100);
		vratiFilmSaId.executeOperation();
		Movie movie = vratiFilmSaId.getMovie();

		assertEquals(movie, null);
	}
}
