package chaining;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public String username="admin";
	public String password="wKFaYB7jp2lB";
	public static String sys_ID;
	public static RequestSpecification requestSpecification;
	public static Response response;
	
	@BeforeSuite
	public void setPrerequisiteData()
	{
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic(username, password);
		
		requestSpecification = RestAssured.given().log().all().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields","number,short_description,sys_id,category,type");
	}
	
	@AfterMethod
	public void afterMethodRun()
	{
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
