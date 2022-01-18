package week2.assignments;

import java.io.File;

import org.testng.annotations.Test;

public class CreateIssueInJIRA extends BaseClass{
	
	@Test
	public void createIssue()
	{
		response = requestSpecification
		.body(new File("./jiraassignmentsdata/createissue3.json"))
		.post("issue")
		.then().assertThat().statusCode(201).extract().response();
		
		issueKey=response.jsonPath().get("key");
	}

}
