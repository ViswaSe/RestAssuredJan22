package week2.assignments;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class UpdateIssueWithDescription extends BaseClass {

	@Test(dependsOnMethods="week2.assignments.CreateJIRAissuesUsingFiles.createJIRAissues")
	public void updateIssueWithDescription()
	{
		response = requestSpecification
		.pathParam("issue_key", issueKey)
		.body(new File("./jiraassignmentsdata/updateissue2.json"))
		.put("issue/{issue_key}")
		.then().assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204).extract().response();
	}
	
}
