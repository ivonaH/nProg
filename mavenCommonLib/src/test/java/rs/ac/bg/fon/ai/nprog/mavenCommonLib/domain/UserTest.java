package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void testSetUserId() {
		user.setUserId(2);
		assertEquals(2, user.getUserId());
	}

	@Test
	public void testSetUsername() {
		user.setUsername("ivona98");
		assertEquals("ivona98", user.getUsername());
	}

	@Test
	public void testSetName() {
		user.setName("Ivona");
		assertEquals("Ivona", user.getName());
	}

	@Test
	public void testSetLastname() {
		user.setLastname("Ivonic");
		assertEquals("Ivonic", user.getLastname());
	}

	@Test
	public void testSetPassword() {
		user.setPassword("ivona");
		assertEquals("ivona", user.getPassword());
	}

	@Test
	public void testGetTableName() {
		assertEquals("user", user.getTableName());
	}

	@Test
	public void testGetParameters() {
		user=new User(2,"pera","pera1","Pera","Peric");
		assertEquals("2, 'pera','Peric','pera1','Pera'", user.getParameters());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("UserId,Username,Password,Name,Lastname", user.getParameterNames());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		user.setUserId(10);
		assertEquals(10, user.getPrimaryKeyValue());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("userId",user.getPrimaryKeyName());
	}

	@Test
	public void testConvertRSList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUpdateQuery() {
		user.setUserId(2);
		user.setUsername("pera1");
		user.setPassword("pera123");
		user.setName("Pera");
		user.setLastname("Peric");
		assertEquals("UserId=2, Username='pera1', Password='pera123', Name='Pera', Lastname='Peric'",user.getUpdateQuery());
		}

	@Test
	public void testGetJoinCondition() {
		assertEquals(null, user.getJoinCondition());
		}

	@Test
	public void testGetSortCondition() {
		assertEquals(null, user.getJoinCondition());
	}

	@Test
	public void testEqualsObjectNull() {
		assertFalse(user.equals(null));
		}
	
	@Test
	public void testEqualsObjectDrugaKlasa() {
		assertFalse(user.equals(new Object()));
		}
	
	@Test
	public void testEqualsObjectNijeIstiUsername() {
		User u2=new User();
		u2.setUsername("Mika");
		user.setUsername("Pera");

		assertFalse(user.equals(u2));
		}
	
	@Test
	public void testEqualsObjectIstiUsername() {
		User u2=new User();
		u2.setUsername("Pera");
		user.setUsername("Pera");
		assertTrue(user.equals(u2));
		}

	
}
