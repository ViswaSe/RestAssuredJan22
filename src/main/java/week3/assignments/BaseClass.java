package week3.assignments;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static Response response;
	public static RequestSpecification requestSpecification;
	public static String sys_ID;
	
	@BeforeSuite
	public void preActions()
	{
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/problem";
		RestAssured.authentication=RestAssured.oauth2("qLmcvVOLHRx7sQrEtQiXWNuCJ5EieObFdjqgqyKlFb0utsWovi6xyU2i_S7g06wc-DpMYN52slzmy46gsP7lVg");
		
		requestSpecification = RestAssured.given().log().all()
		.queryParam("sysparm_fields","number,state,short_description,sys_id,contact_type,category")
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON);
	}
	
	@AfterMethod
	public void afterMethodCall()
	{
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
