package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;

public class KreirajFilmTest {
	KreirajFilm kreirajFilm;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		kreirajFilm=null;
	}

	@Test(expected = Exception.class)
	public void testKreirajFilmNijeInstancaKlase() throws Exception {
		Showtime showtime=new Showtime();
		kreirajFilm=new KreirajFilm(showtime);
	}

}
