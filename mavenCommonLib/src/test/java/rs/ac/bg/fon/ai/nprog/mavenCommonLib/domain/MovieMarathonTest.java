package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieMarathonTest {
	MovieMarathon mm;
	@Before
	public void setUp() throws Exception {
		mm=new MovieMarathon();
		mm.setMarathonId(1);
		mm.setName("Maraton1");
		User user = new User("pera", "pera123");
		user.setUserId(12);
		mm.setUser(user);
	}

	@After
	public void tearDown() throws Exception {
		mm=null;
	}

	@Test
	public void testSetMarathonId() {
		assertEquals(1, mm.getMarathonId());
	}

	@Test
	public void testSetName() {
		assertEquals("Maraton1", mm.getName());
	}

	@Test
	public void testSetUser() {
		User user1 = new User("pera", "pera123");
		assertEquals(user1,mm.getUser());	
	}

	@Test
	public void testGetTableName() {
		assertEquals("MovieMarathon", mm.getTableName());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, 'Maraton1', 12", mm.getParameters());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("MarathonId, Name, UserId", mm.getParameterNames());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(1, mm.getPrimaryKeyValue());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("MarathonId", mm.getPrimaryKeyName());
	}

	@Test
	public void testGetUpdateQuery() {
		assertEquals("MarathonId=1", mm.getUpdateQuery());
	}

	@Test
	public void testGetJoinCondition() {
		assertEquals(null, mm.getJoinCondition());
	}

	@Test
	public void testGetSortCondition() {
		assertEquals("name", mm.getSortCondition());
	}

	@Test
	public void testEqualsObjectNull() {
		assertFalse(mm.equals(null));
	}

	@Test
	public void testEqualsObjectDrugaKlasa() {
		assertFalse(mm.equals(new Object()));
	}

	@Test
	public void testEqualsObjectNisuIsti() {
		MovieMarathon mm1 = new MovieMarathon();
		mm1.setMarathonId(2);	
		assertFalse(mm.equals(mm1));
	}

	@Test
	public void testEqualsObjectIsti() {
		MovieMarathon mm1 = new MovieMarathon();
mm1.setMarathonId(1);	
assertTrue(mm.equals(mm1));
	}
	
}
