package week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllChangeRequestUsingCookieSessionID {

	@Test()
	public void getAllChangeRequest()
	{
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		
		Response response = RestAssured.given().log().all()
		.cookie("JSESSIONID","B0886A0449DB042D884EE829760EEDD6")
		.param("sysparm_fields", "number,short_description,sys_id")
		.get();
		
		response.prettyPrint();
		int result_size = response.jsonPath().getList("result.number").size();
		System.out.println(result_size);
	}
	
}
