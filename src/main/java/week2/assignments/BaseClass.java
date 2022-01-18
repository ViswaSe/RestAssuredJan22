package week2.assignments;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public String username="vidhyavishveshwar@gmail.com";
	public String password="765jZCfMfQxMfQ19IHKjA111";
	
	public static RequestSpecification requestSpecification;
	public static Response response;
	
	public static String issueKey;
	
	@BeforeSuite
	public void settingPrerequisiteData()
	{
		RestAssured.baseURI="https://restapi2022.atlassian.net/rest/api/2";
		RestAssured.authentication=RestAssured.preemptive().basic(username,password);
	
		requestSpecification=RestAssured.given().log().all()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON);
	}
	
	@AfterMethod
	public void afterMethodCall()
	{
		System.out.println(response.statusCode());
		response.prettyPrint();
	}

}
