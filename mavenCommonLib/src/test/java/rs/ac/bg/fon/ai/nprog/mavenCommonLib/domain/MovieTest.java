package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {
	Movie movie;

	@Before
	public void setUp() throws Exception {
		movie = new Movie();
		movie.setDirector("Pera Peric");
		movie.setDurationInMinutes(120);
		movie.setGenre(Genre.action);
		movie.setMovieId(1);
		movie.setName("Film1");
		User user = new User("pera", "pera123");
		user.setUserId(12);
		movie.setUser(user);
		movie.setYear(2020);
	}

	@After
	public void tearDown() throws Exception {
		movie = null;
	}

	@Test
	public void testSetMovieId() {
		assertEquals(1, movie.getMovieId());
	}

	@Test
	public void testSetName() {
		assertEquals("Film1", movie.getName());
	}

	@Test
	public void testSetGenre() {
		assertEquals(Genre.action, movie.getGenre());
	}

	@Test
	public void testSetDirector() {
		assertEquals("Pera Peric", movie.getDirector());
	}

	@Test
	public void testSetYear() {
		assertEquals(2020, movie.getYear());
	}

	@Test
	public void testSetUser() {
		User u1 = new User("pera", "pera123");
		assertEquals(u1, movie.getUser());
	}

	@Test
	public void testSetDurationInMinutes() {
		assertEquals(120, movie.getDurationInMinutes());
	}

	@Test
	public void testGetTableName() {
		assertEquals("Movie", movie.getTableName());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, 'Film1','action','Pera Peric',2020,120, 12", movie.getParameters());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("movieId, name, genre, director, year, durationInMinutes, userId", movie.getParameterNames());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(1, movie.getPrimaryKeyValue());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("MovieId", movie.getPrimaryKeyName());
	}

//	@Test
//	public void testConvertRSList() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetUpdateQuery() {
		assertEquals(
				"MovieId=1, Name='Film1', Genre='action', director='Pera Peric', Year=2020,DurationInMinutes=120 UserId=12",
				movie.getUpdateQuery());
	}

	@Test
	public void testToString() {
		assertTrue(movie.toString().contains("Film1 2020"));
		}

	@Test
	public void testGetJoinCondition() {
		assertEquals(null,movie.getJoinCondition());
	}

	@Test
	public void testEqualsObjectNull() {
		assertFalse(movie.equals(null));
	}

	@Test
	public void testEqualsObjectDrugaKlasa() {
		assertFalse(movie.equals(new Object()));
	}
	
	@Test
	public void testEqualsObjectNisuIsti() {
		Movie m=new Movie(2, "Film2");
		assertFalse(movie.equals(m));
	}
	
	@Test
	public void testEqualsObjectIsti() {
		
		Movie movie1 = new Movie();
		movie1.setDirector("Pera Peric");
		movie1.setGenre(Genre.action);
		movie1.setMovieId(1);
		movie1.setName("Film1");
		movie1.setYear(2020);
		assertTrue(movie.equals(movie1));
	}
	
	@Test
	public void testGetSortCondition() {
		assertEquals("year DESC, name ASC", movie.getSortCondition());
	}

}
