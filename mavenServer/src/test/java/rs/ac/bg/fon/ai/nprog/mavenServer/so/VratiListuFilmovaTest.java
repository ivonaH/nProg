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

public class VratiListuFilmovaTest {
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
		
		//User 2
		
		query="INSERT INTO user VALUES(2,'pera','Pera','Peric','pera123')";
		statement.executeUpdate(query);

		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (1,'Movie1','adventure','Director 1',2020,120,1)";
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (2,'Movie2','action','Director 2',2019,100,1)";
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (3,'Movie3','horror','Director 3',2017,70,2)";
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (4,'Movie4','drama','Director 4',2015,65,2)";
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
	}

	@Test
	public void testVratiListuFilmova() throws Exception {
		VratiListuFilmova vratiListuFilmova=new VratiListuFilmova();
		vratiListuFilmova.executeOperation();
		List<Movie> moviesFromDb=vratiListuFilmova.getMovies();
		List<Movie>movies=new ArrayList<>();
		movies.add(new Movie(1,"Movie1",Genre.adventure,"Director 1",2020,120,new User(1)));
		movies.add(new Movie(2,"Movie2",Genre.action,"Director 2",2019,100,new User(1)));
		movies.add(new Movie(3,"Movie3",Genre.horror,"Director 3",2017,70,new User(2)));
		movies.add(new Movie(4,"Movie4",Genre.drama,"Director 4",2015,65,new User(2)));

		
		assertEquals(movies,moviesFromDb);
	}

}
