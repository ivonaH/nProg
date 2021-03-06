package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class KreirajFilmTest {
	KreirajFilm kreirajFilm;
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
		connection.commit();
        statement.close();

	}

	@After
	public void tearDown() throws Exception {
		String query = "Delete from movie";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		//brisanje usera
		query = "Delete from user";
//		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		connection.commit();
        statement.close();
		kreirajFilm = null;
	}

	@Test(expected = Exception.class)
	public void testKreirajFilmNijeInstancaKlase() throws Exception {
		Showtime showtime = new Showtime();
		kreirajFilm = new KreirajFilm(showtime);
	}
	
	@Test
	public void testSacuvajUBazi() throws Exception {
		Movie movie=new Movie("Avatar", Genre.adventure, "James Cameron", 2009, 162, new User(1));
		kreirajFilm = new KreirajFilm(movie);
		kreirajFilm.executeOperation();
		String querySelect="SELECT * FROM movie Where name='Avatar'";
		Statement statement = connection.createStatement();
		ResultSet rs=statement.executeQuery(querySelect);
		List<Movie> list=new ArrayList<>();
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

           Movie movieDb=list.get(0);
           assertEquals(movie, movieDb);

	}

}
