package week2.assignments;

import java.io.File;

import org.testng.annotations.Test;

public class UpdateJiraIssue extends BaseClass{
	
	@Test(dependsOnMethods= {"week2.assignments.CreateIssueInJIRA.createIssue"})
	public void updateJIRAissue()
	{
		response = requestSpecification.pathParam("issue_key", issueKey)
		.body(new File("./jiraassignmentsdata/updateissue1.json"))
		.put("issue/{issue_key}")
		.then().assertThat().statusCode(204).extract().response();
	}

}
