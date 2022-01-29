package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseServiceRequest {
	
	public static RequestSpecification request;
	public static Response response;
	public static String issueKey;
	
	@BeforeSuite
	public void setup() throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream("./src/test/resources/config.properties"));
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		String server = prop.getProperty("server");
		String resources = prop.getProperty("resources");
		
		RestAssured.baseURI=server+"/"+resources+"/";
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
	}
	
	@BeforeMethod
	public void setupRequestSpecification()
	{
		request=RestAssured.given().log().all().accept(ContentType.JSON).contentType(ContentType.JSON);
	}
	
	@AfterMethod
	public void tearDown()
	{
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
