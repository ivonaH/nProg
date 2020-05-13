package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;

public class IzmeniProjekcijuTest {
	IzmeniProjekciju izmeniProjekciju;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		izmeniProjekciju=null;
	}

	@Test(expected = Exception.class)
	public void testIzmeniProjekcijuNijeInstancaKlase() throws Exception {
		Movie movie=new Movie();
		izmeniProjekciju=new IzmeniProjekciju(movie);
	}

}
