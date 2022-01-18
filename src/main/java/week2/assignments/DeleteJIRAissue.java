package week2.assignments;

import org.testng.annotations.Test;

public class DeleteJIRAissue extends BaseClass{

	@Test(dependsOnMethods= {"week2.assignments.UpdateJiraIssue.updateJIRAissue"})
	public void deleteJiraIssue()
	{
		response = requestSpecification.pathParam("issue_key",issueKey)
		.delete("issue/{issue_key}")
		.then().assertThat().statusCode(204).extract().response();
	}
}
