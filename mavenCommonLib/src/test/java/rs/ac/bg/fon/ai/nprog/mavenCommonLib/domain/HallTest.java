package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HallTest {
	Hall hall;

	@Before
	public void setUp() throws Exception {
		hall = new Hall();
		hall.setCapacity(100);
		hall.setHallId(1);
		hall.setName("Petar pan");
	}

	@After
	public void tearDown() throws Exception {
		hall = null;
	}

	@Test
	public void testSetHallId() {
		assertEquals(1, hall.getHallId());
	}

	@Test
	public void testSetName() {
		assertEquals("Petar pan", hall.getName());
	}

	@Test
	public void testSetCapacity() {
		assertEquals(100, hall.getCapacity());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, 'Petar pan', 100", hall.getParameters());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("HallId, Name, Capacity", hall.getParameterNames());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(1, hall.getPrimaryKeyValue());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("HallId", hall.getPrimaryKeyName());
	}

	@Test
	public void testGetUpdateQuery() {
		assertEquals("HallId=1, Name='Petar pan', Capacity=100", hall.getUpdateQuery());
	}

	@Test
	public void testToString() {
		assertTrue(hall.toString().contains("Petar pan"));
	}

	@Test
	public void testGetJoinCondition() {
		assertEquals(null,hall.getJoinCondition());
	}

	@Test
	public void testGetSortCondition() {
		assertEquals("Name", hall.getSortCondition());
	}

	@Test
	public void testEqualsObjectNull() {
		assertFalse(hall.equals(null));
	}

	@Test
	public void testEqualsObjectDrugaKlasa() {
		assertFalse(hall.equals(new Object()));
	}
	
	@Test
	public void testEqualsObjectNisuIsti() {
		Hall hall1=new Hall();
		hall.setHallId(21);
		assertFalse(hall.equals(hall1));
	}
	
	@Test
	public void testEqualsObjectIsti() {
		Hall hall1=new Hall();
		hall.setHallId(1);
		assertFalse(hall.equals(hall1));
	}
	
}
