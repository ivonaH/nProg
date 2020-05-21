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

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;

public class NadjiRadnikaTest {
	List<String> columns;
	List<String> values;

	private static Connection connection;
	NadjiRadnika nadjiRadnika;

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
		columns=new ArrayList<>();
		values=new ArrayList<>();
		
		String query = "INSERT INTO user VALUES(1,'ivona','Ivona','Heldrih','ivona123')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		//User 2
		
		query="INSERT INTO user VALUES(2,'pera','Pera','Peric','pera123')";
		statement.executeUpdate(query);
		
		connection.commit();
        statement.close();
	}

	@After
	public void tearDown() throws Exception {
		
		columns=null;
		values=null;
		
		nadjiRadnika=null;
		String query = "Delete from user";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		connection.commit();
        statement.close();
	}

	@Test
	public void NadjiRadnikaTestUspesno() throws Exception {
		columns.add("username");
		values.add("ivona");
		
		columns.add("password");
		values.add("ivona123");
		
		nadjiRadnika=new NadjiRadnika(columns, values);
		nadjiRadnika.executeOperation();
		
		User user=new User("ivona", "ivona123");
		
		assertEquals(user,nadjiRadnika.getUser());
		
	}
	
	@Test
	public void NadjiRadnikaTestPogresanUsername() throws Exception {
		columns.add("username");
		values.add("ivona1234");
		
		columns.add("password");
		values.add("ivona123");
		
		nadjiRadnika=new NadjiRadnika(columns, values);
		nadjiRadnika.executeOperation();
				
		assertEquals(null,nadjiRadnika.getUser());
		}

	@Test
	public void NadjiRadnikaTestPogresanPassword() throws Exception {
		columns.add("username");
		values.add("ivona");
		
		columns.add("password");
		values.add("ivona12345678");
		
		nadjiRadnika=new NadjiRadnika(columns, values);
		nadjiRadnika.executeOperation();
		
		
		assertEquals(null,nadjiRadnika.getUser());
		}

	@Test
	public void NadjiRadnikaTestPogresniUsernamePassword() throws Exception {
		columns.add("username");
		values.add("ivona122");
		
		columns.add("password");
		values.add("ivona12345678");
		
		nadjiRadnika=new NadjiRadnika(columns, values);
		nadjiRadnika.executeOperation();
		
		
		assertEquals(null,nadjiRadnika.getUser());
		}

	
}


