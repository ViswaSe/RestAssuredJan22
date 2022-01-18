package week2.assignments;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateNewIssueWithAttachment extends BaseClass{
	
	@Test(dependsOnMethods= {"week2.assignments.CreateIssueInJIRA.createIssue"})
	public void createIssueWithAttachment()
	{		
		response = requestSpecification.pathParam("issue_key", issueKey)
		.contentType(ContentType.MULTIPART)
		.accept(ContentType.JSON)
		.header("X-Atlassian-Token", "no-check")
		.multiPart(new File("./jiraassignmentsdata/createissue3.json"))
		.post("issue/{issue_key}/attachments")
		.then().assertThat().statusCode(200).extract().response();
		
	}

}
