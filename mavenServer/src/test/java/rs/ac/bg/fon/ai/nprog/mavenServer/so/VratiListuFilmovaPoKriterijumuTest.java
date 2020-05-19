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

public class VratiListuFilmovaPoKriterijumuTest {

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
		
		//User 3
		
		query="INSERT INTO user VALUES(3,'ana','Ana','Anic','ana123')";
		statement.executeUpdate(query);

		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (1,'Movie1','adventure','Director 1',2020,120,1)";
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (2,'Movie2','action','Director 2',2019,100,1)";
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (3,'Movie3','horror','Director 3',2017,70,3)";
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (4,'Movie4','drama','Director 4',2015,65,2)";
		statement.executeUpdate(query);
		
		query="INSERT INTO movie(MovieId,Name, Genre, Director, Year, DurationInMinutes, UserId) values (5,'Movie5','horror','Director 3',2017,90,3)";
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
	public void testVratiListuFilmovaPoKriterijumuUserId() throws Exception {
		List<String> columns=new ArrayList<>();
		List<String> values=new ArrayList<>();
		columns.add("UserId");
		values.add("1");

		VratiListuFilmovaPoKriterijumu vratiListuFilmovaPoKriterijumu=new VratiListuFilmovaPoKriterijumu(columns,values);
		vratiListuFilmovaPoKriterijumu.executeOperation();
		List<Movie> moviesFromDb=vratiListuFilmovaPoKriterijumu.getMovies();
		List<Movie>movies=new ArrayList<>();
		movies.add(new Movie(1,"Movie1",Genre.adventure,"Director 1",2020,120,new User(1)));
		movies.add(new Movie(2,"Movie2",Genre.action,"Director 2",2019,100,new User(1)));
		
		assertEquals(movies,moviesFromDb);
	}
	
	@Test
	public void testVratiListuFilmovaPoKriterijumuMovieIdAndUserId() throws Exception {
		List<String> columns=new ArrayList<>();
		List<String> values=new ArrayList<>();
		columns.add("UserId");
		values.add("1");
		
		columns.add("MovieId");
		values.add("1");

		VratiListuFilmovaPoKriterijumu vratiListuFilmovaPoKriterijumu=new VratiListuFilmovaPoKriterijumu(columns,values);
		vratiListuFilmovaPoKriterijumu.executeOperation();
		List<Movie> moviesFromDb=vratiListuFilmovaPoKriterijumu.getMovies();
		List<Movie>movies=new ArrayList<>();
		movies.add(new Movie(1,"Movie1",Genre.adventure,"Director 1",2020,120,new User(1)));
		
		assertEquals(movies,moviesFromDb);
	}
	
	@Test
	public void testVratiListuFilmovaPoKriterijumuGenreYearDirectorUserId() throws Exception {
		List<String> columns=new ArrayList<>();
		List<String> values=new ArrayList<>();
		columns.add("UserId");
		values.add("3");
		
		columns.add("Genre");
		values.add("horror");
		
		columns.add("Director");
		values.add("Director 3");
		
		columns.add("Year");
		values.add("2017");

		VratiListuFilmovaPoKriterijumu vratiListuFilmovaPoKriterijumu=new VratiListuFilmovaPoKriterijumu(columns,values);
		vratiListuFilmovaPoKriterijumu.executeOperation();
		List<Movie> moviesFromDb=vratiListuFilmovaPoKriterijumu.getMovies();
		List<Movie>movies=new ArrayList<>();
		//(3,'Movie3','horror','Director 3',2017,70,2)";
		//5,'Movie5','horror','Director 3',2017,90,3

		movies.add(new Movie(3,"Movie3",Genre.horror,"Director 3",2017,70,new User(3)));
		movies.add(new Movie(5,"Movie5",Genre.horror,"Director 3",2017,90,new User(3)));
		
		assertEquals(movies,moviesFromDb);
	}
	
	@Test
	public void testVratiListuFilmovaPoKriterijumuSviKriterijumi() throws Exception {
		List<String> columns=new ArrayList<>();
		List<String> values=new ArrayList<>();
		
		columns.add("MovieId");
		values.add("3");
		
		columns.add("Name");
		values.add("Movie3");
		
		columns.add("UserId");
		values.add("3");
		
		columns.add("Genre");
		values.add("horror");
		
		columns.add("Director");
		values.add("Director 3");
		
		columns.add("Year");
		values.add("2017");
		
		columns.add("DurationInMinutes");
		values.add("70");

		VratiListuFilmovaPoKriterijumu vratiListuFilmovaPoKriterijumu=new VratiListuFilmovaPoKriterijumu(columns,values);
		vratiListuFilmovaPoKriterijumu.executeOperation();
		List<Movie> moviesFromDb=vratiListuFilmovaPoKriterijumu.getMovies();
		List<Movie>movies=new ArrayList<>();
		
		movies.add(new Movie(3,"Movie3",Genre.horror,"Director 3",2017,70,new User(3)));
		
		assertEquals(movies,moviesFromDb);
	}
	
	@Test
	public void testVratiListuFilmovaPoKriterijumuNepostojeci() throws Exception {
		List<String> columns=new ArrayList<>();
		List<String> values=new ArrayList<>();
		columns.add("UserId");
		values.add("10");

		VratiListuFilmovaPoKriterijumu vratiListuFilmovaPoKriterijumu=new VratiListuFilmovaPoKriterijumu(columns,values);
		vratiListuFilmovaPoKriterijumu.executeOperation();
		List<Movie> moviesFromDb=vratiListuFilmovaPoKriterijumu.getMovies();
				
		assertTrue(moviesFromDb.isEmpty());
	}

}
