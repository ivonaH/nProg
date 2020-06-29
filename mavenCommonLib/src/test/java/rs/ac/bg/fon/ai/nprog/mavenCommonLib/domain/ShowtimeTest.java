package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShowtimeTest {
	Showtime showtime;

	@Before
	public void setUp() throws Exception {
		showtime = new Showtime();
		Hall hall = new Hall();
		hall.setCapacity(100);
		hall.setHallId(111);
		hall.setName("Petar pan");
		showtime.setHall(hall);
		Movie movie = new Movie();
		movie.setDirector("Pera Peric");
		movie.setDurationInMinutes(120);
		movie.setGenre(Genre.action);
		movie.setMovieId(1);
		movie.setName("Film1");
		User user = new User("pera", "pera123");
		user.setUserId(12);
		movie.setUser(user);
		movie.setYear(2020);
		showtime.setMovie(movie);
		showtime.setShowtimeId(1);
		User userS = new User("ivona", "ivona123");
		userS.setUserId(55);
		showtime.setUser(userS);
		SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
		showtime.setDate(stf.parse("2020-05-15"));
		stf = new SimpleDateFormat("HH:mm:ss");
		showtime.setTime(stf.parse("15:00:00"));

		MovieMarathon mm = new MovieMarathon();
		mm.setMarathonId(1111);
		showtime.setMovieMarathon(mm);
	}

	@After
	public void tearDown() throws Exception {
		showtime = null;
	}

	@Test
	public void testSetShowtimeId() {
		assertEquals(1, showtime.getShowtimeId());
	}

	@Test
	public void testSetDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			assertEquals(sdf.parse("2020-05-15"), showtime.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			assertEquals(sdf.parse("15:00:00"), showtime.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSetUser() {
		User user1 = new User("ivona", "ivona123");
		user1.setUserId(12);
		assertEquals(user1, showtime.getUser());
	}

	@Test
	public void testSetHall() {
		Hall hall = new Hall();
		hall.setCapacity(100);
		hall.setHallId(111);
		hall.setName("Petar pan");
		assertEquals(hall, showtime.getHall());
	}

	@Test
	public void testSetMovie() {
		Movie movie = new Movie();
		movie.setDirector("Pera Peric");
		movie.setYear(2020);
		movie.setGenre(Genre.action);
		movie.setMovieId(1);
		movie.setName("Film1");
		assertEquals(movie, showtime.getMovie());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, '2020-05-15','15:00:00',55,111,1", showtime.getParameters());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("ShowtimeId, Date, Time, UserId, HallId, MovieId", showtime.getParameterNames());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(1, showtime.getPrimaryKeyValue());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("ShowtimeId", showtime.getPrimaryKeyName());
	}

	@Test
	public void testGetUpdateQuery() {
		assertEquals(" hallId=111, movieMarathonId=1111", showtime.getUpdateQuery());
	}

	@Test
	public void testToString() {
		assertTrue(showtime.toString().contains("1"));
		assertTrue(showtime.toString().contains("15:00:00"));
	}

	@Test
	public void testGetJoinCondition() {
		assertEquals(" JOIN Hall h on h.Hallid=t.HallId JOIN Movie m on t.movieId=m.movieId",
				showtime.getJoinCondition());
	}

	@Test
	public void testGetSortCondition() {
		assertEquals(" time asc", showtime.getSortCondition());
	}

	@Test
	public void testEqualsObjectNull() {
		assertFalse(showtime.equals(null));
	}

	@Test
	public void testEqualsObjectDrugaKlasa() {
		assertFalse(showtime.equals(new Object()));
	}

	@Test
	public void testEqualsObjectNisuIsti() {
		Showtime s1 = new Showtime();
		s1.setShowtimeId(2);
		assertFalse(showtime.equals(s1));
	}

	@Test
	public void testEqualsObjectIsti() {
		Showtime s1 = new Showtime();
		s1.setShowtimeId(1);
		assertTrue(showtime.equals(s1));
	}

}
