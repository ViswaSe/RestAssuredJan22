package week3.assignments;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class VerifySchemaInCreatingJIRAIssue {
	
	@Test
	public void verifySchemaInCreateIssue()
	{
		String username="vidhyavishveshwar@gmail.com";
		String password="ThdBj4lgkLCIzWZuoJl236F8";
		
		RestAssured.baseURI="https://restapi2022.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
		
		Response response = RestAssured.given().log().all()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(new File("./jiradata/createissueforschema.json"))
		.post()
		.then().assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.body("key",Matchers.containsString("RA"))
		.body(JsonSchemaValidator.matchesJsonSchema(new File("./schema/createissue_schema.json")))
		.extract().response();
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	}

}
