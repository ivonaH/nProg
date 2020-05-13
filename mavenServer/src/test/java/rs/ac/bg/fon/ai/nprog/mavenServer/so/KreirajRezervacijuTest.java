package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;

public class KreirajRezervacijuTest {
	KreirajRezervaciju kreirajRezervaciju;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		kreirajRezervaciju=null;
	}

	@Test(expected = Exception.class)
	public void testKreirajRezervacijuNijeInstancaKlase() throws Exception {
		Movie movie=new Movie();
		kreirajRezervaciju=new KreirajRezervaciju(movie);
	}

}
