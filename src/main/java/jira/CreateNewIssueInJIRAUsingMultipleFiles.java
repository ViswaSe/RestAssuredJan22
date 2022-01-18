package jira;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateNewIssueInJIRAUsingMultipleFiles {
	
	@DataProvider(name="fetchData")
	public String[] setData()
	{
		String[] data= new String[2];
		data[0] = "./jiradata/create_issue1.json";
		data[1] = "./jiradata/create_issue2.json";
		
		return data;
	}
	
	@Test(dataProvider="fetchData")
	public void createIssuesUsingMultipleFiles(String filePath)
	{
		String username="vidhyavishveshwar@gmail.com";
		String password="765jZCfMfQxMfQ19IHKjA111";
		
		RestAssured.baseURI="https://restapi2022.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
		
		Response response = RestAssured.given().log().all()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(new File(filePath))
		.post();
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		
		JsonPath jsonResponse = response.jsonPath();
		String keyValue=jsonResponse.get("key");
		System.out.println(keyValue);
	}

}
