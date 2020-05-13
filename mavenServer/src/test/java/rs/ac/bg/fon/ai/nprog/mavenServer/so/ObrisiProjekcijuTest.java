package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;

public class ObrisiProjekcijuTest {
	ObrisiProjekciju obrisiProjekciju;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		obrisiProjekciju=null;
	}

	@Test(expected = Exception.class)
	public void testObrisiProjekcijuNijeInstancaKlase() throws Exception {
		Movie movie=new Movie();
		obrisiProjekciju=new ObrisiProjekciju(movie);
	}

}
