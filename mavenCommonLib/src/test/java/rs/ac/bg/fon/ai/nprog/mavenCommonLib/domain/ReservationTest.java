package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReservationTest {
	Reservation reservation;

	@Before
	public void setUp() throws Exception {
		reservation=new Reservation();
		reservation.setEmail("pera@gmail.com");
		reservation.setNameLastname("Pera Peric");
		reservation.setReservationId(1);
		User user1=new User("iv", "iv12");
		user1.setUserId(11);
		reservation.setUser(user1);
		
		//Showtime...
		Showtime showtime=new Showtime();
		showtime.setShowtimeId(12);

		Movie movie=new Movie(122, "Film1");
		showtime.setMovie(movie);
		reservation.setShowtime(showtime);
	}

	@After
	public void tearDown() throws Exception {
		reservation=null;
	}

	@Test
	public void testSetReservationId() {
		assertEquals(1, reservation.getReservationId());
}

	@Test
	public void testSetNameLastname() {
		assertEquals("Pera Peric", reservation.getNameLastname());
	}

	@Test
	public void testSetEmail() {
		assertEquals("pera@gmail.com", reservation.getEmail());
	}

	@Test
	public void testSetUser() {
		User user=new User("iv", "iv12");
		user.setUserId(11);
		assertEquals(user, reservation.getUser());
	}

	@Test
	public void testSetShowtime() {
		Showtime showtime1=new Showtime();
		showtime1.setShowtimeId(12);
		assertEquals(showtime1, reservation.getShowtime());
	}

	@Test
	public void testGetTableName() {
		assertEquals("Reservation", reservation.getTableName());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, 'Pera Peric','pera@gmail.com', 11, 12", reservation.getParameters());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("ReservationId, NameLastname, Email, UserId, ShowtimeId", reservation.getParameterNames());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(1, reservation.getPrimaryKeyValue());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("ReservationId", reservation.getPrimaryKeyName());
	}

//	@Test
//	public void testConvertRSList() {
//
//		}

	@Test
	public void testGetUpdateQuery() {
		assertEquals("ReservationId=1, NameLastname= 'Pera Peric', Email='pera@gmail.com', UserId=11, ShowtimeId=12", reservation.getUpdateQuery());
	}

	@Test
	public void testGetJoinCondition() {
		assertEquals("JOIN Showtime s on s.showtimeId=t.showtimeId JOIN Movie m on m.movieId=s.movieId JOIN hall h on h.hallId=s.hallId", reservation.getJoinCondition());
	}

	@Test
	public void testToString() {
		assertTrue(reservation.toString().contains("Pera Peric"));
		assertTrue(reservation.toString().contains("Film1"));

	}

	@Test
	public void testGetSortCondition() {
		assertEquals(null, reservation.getSortCondition());
	}

}
