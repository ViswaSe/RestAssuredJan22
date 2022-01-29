package services;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateNewJIRAIssue extends BaseServiceRequest {
	
	@Test
	public void createNewJIRAIssue()
	{
		response = request.body(new File("./data/createissue.json"))
				.when()
				.post("issue")
				.then()
				.assertThat()
				.statusCode(201)
				.contentType(ContentType.JSON)
				.body("key", Matchers.containsString("RA"))
				.extract().response();
		
		issueKey = response.jsonPath().get("key");
	}

}
