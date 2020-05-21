package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Hall;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class VratiListuSalaTest {
	VratiListuSala vratiListuSala;
	private static Connection connection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String url = "jdbc:mysql://localhost:3306/testBioskop";
		String user = "root";
		String password = "";
		connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		
		DatabaseConnection.getInstance().setUrl("jdbc:mysql://localhost:3306/testBioskop");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//vraca na originalnu bazu
		DatabaseConnection.getInstance().setUrl(Configuration.getInstance().getUrl());
		connection.close();
	}

	@Before
	public void setUp() throws Exception {
		vratiListuSala=new VratiListuSala();
		String query = "INSERT INTO hall values (1,'Hall1',100)";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		
		query = "INSERT INTO hall values (2,'Hall2',200)";
		statement.executeUpdate(query);
		
		query = "INSERT INTO hall values (3,'Hall3',300)";
		statement.executeUpdate(query);
		
		query = "INSERT INTO hall values (4,'Hall4',290)";
		statement.executeUpdate(query);
		
		query = "INSERT INTO hall values (5,'Hall5',280)";
		statement.executeUpdate(query);
		
		query = "INSERT INTO hall values (6,'Hall6',250)";
		statement.executeUpdate(query);
		
		connection.commit();
        statement.close();

	}

	@After
	public void tearDown() throws Exception {
		String query = "Delete from hall";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
	
		connection.commit();
        statement.close();
		vratiListuSala = null;
	}


	@Test
	public void VratiListuSala() throws Exception {
		List<Hall> halls=new ArrayList<>();
		halls.add(new Hall(1,"Hall1",100));
		halls.add(new Hall(2,"Hall2",200));
		halls.add(new Hall(3,"Hall3",300));
		halls.add(new Hall(4,"Hall4",280));
		halls.add(new Hall(5,"Hall5",250));
		
		vratiListuSala.executeOperation();
		
		List<Hall> hallsDb=vratiListuSala.getHalls();
		
		assertEquals(hallsDb,halls);
		
	}

}
