package services;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateJIRAIssue extends BaseServiceRequest{

	@Test(dependsOnMethods="services.CreateNewJIRAIssue.createNewJIRAIssue")
	public void updateJIRAIssue()
	{
		response = request.body(new File("./data/updateissue.json"))
		.pathParam("issue_key", issueKey)
		.put("issue/{issue_key}")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.extract().response();
	}
	
}
