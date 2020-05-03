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
		user.setUserId(2);
		user.setUsername("ivona98");
		user.setName("Ivona");
		user.setLastname("Ivonic");
		user.setPassword("ivona123");

	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void testSetUserId() {
		assertEquals(2, user.getUserId());
	}

	@Test
	public void testSetUsername() {
		assertEquals("ivona98", user.getUsername());
	}

	@Test
	public void testSetName() {
		assertEquals("Ivona", user.getName());
	}

	@Test
	public void testSetLastname() {
		assertEquals("Ivonic", user.getLastname());
	}

	@Test
	public void testSetPassword() {
		assertEquals("ivona123", user.getPassword());
	}

	@Test
	public void testGetTableName() {
		assertEquals("user", user.getTableName());
	}

	@Test
	public void testGetParameters() {
		assertEquals("2, 'ivona98','ivona123','Ivona','Ivonic'", user.getParameters());
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

//	@Test
//	public void testConvertRSList() {
//		fail("Not yet implemented");
//	}

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
