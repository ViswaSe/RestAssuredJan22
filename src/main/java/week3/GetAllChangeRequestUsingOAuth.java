package week3;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllChangeRequestUsingOAuth {

	@Test
	public void getAllChangeRequest()
	{
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication= RestAssured.oauth2("qLmcvVOLHRx7sQrEtQiXWNuCJ5EieObFdjqgqyKlFb0utsWovi6xyU2i_S7g06wc-DpMYN52slzmy46gsP7lVg");
		
		Response response = RestAssured.given().log().all()
		.param("sysparm_fields", "number,short_description,sys_id")
		.get();
		
		response.prettyPrint();
		int result_size = response.jsonPath().getList("result.number").size();
		System.out.println(result_size);
		
		//Cookie storage in the below section: 
		Map<String,String> allCookies = response.getCookies();
		
		for(Entry<String,String> eachCookie:allCookies.entrySet())
		{
			System.out.println(eachCookie);
		}
		
	}
	
}
