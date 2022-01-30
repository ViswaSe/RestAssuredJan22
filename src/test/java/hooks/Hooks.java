package hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {
	
	@Before
	public void setup() throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream("./src/test/resources/config.properties"));
	
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String server = prop.getProperty("server");
		String resources = prop.getProperty("resources");
		
		String endPoint = server+"/"+resources+"/";
		
		RestAssured.baseURI=endPoint;
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
	}
	
	@After
	public void teardown(Scenario sc)
	{
		System.out.println(sc.getName()+"-"+sc.getStatus());
	}

}
