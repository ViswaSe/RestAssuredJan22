package jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIssuesFromJira {
	
	@Test
	public void getAllIssues()
	{
		String username="vidhyavishveshwar@gmail.com";
		String password="765jZCfMfQxMfQ19IHKjA111";
		
		RestAssured.baseURI="https://restapi2022.atlassian.net/rest/api/2/search";
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
		
		Response response = RestAssured.given().log().all()
		.queryParam("jql", "project = \"RA\"")
		.queryParam("fields", "id,key,description,summary")
		.queryParam("maxResults", "5")
		.get();
		
		response.prettyPrint();
		
	}

}
