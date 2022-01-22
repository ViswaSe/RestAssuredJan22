package week3.assignments;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class UpdateProblemUsingChaining extends BaseClass {
	
	@Test(dependsOnMethods="week3.assignments.CreateNewProblemUsingOAuth2.createProblem")
	public void updateProblem()
	{
		response = requestSpecification
		.pathParam("sys_id", sys_ID)
		.body(new File("./data/updateproblem1.json"))
		.put("{sys_id}")
		.then().assertThat()
		.statusCode(200)
		.body("result.short_description", Matchers.containsString("updated"))
		.extract().response();
	}

}
