package week2.assignments;

import org.testng.annotations.Test;

public class DeleteIssueUsingChaining extends BaseClass {
	
	@Test(dependsOnMethods="week2.assignments.UpdateIssueWithDescription.updateIssueWithDescription")
	public void deleteIssueUsingChaining()
	{
		response = requestSpecification.pathParam("issue_key", issueKey)
		.delete("issue/{issue_key}")
		.then().assertThat().statusCode(204).extract().response();
	}

}
