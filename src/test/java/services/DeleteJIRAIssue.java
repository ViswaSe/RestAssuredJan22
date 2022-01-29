package services;

import org.testng.annotations.Test;

public class DeleteJIRAIssue extends BaseServiceRequest {
	
	@Test(dependsOnMethods="services.UpdateJIRAIssue.updateJIRAIssue")
	public void deleteJIRAIssue()
	{
		response = request.pathParam("issue_key", issueKey)
		.delete("issue/{issue_key}")
		.then()
		.assertThat()
		.statusCode(204).extract().response();
	}

}
