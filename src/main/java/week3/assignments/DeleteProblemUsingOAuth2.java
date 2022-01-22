package week3.assignments;

import org.testng.annotations.Test;

public class DeleteProblemUsingOAuth2 extends BaseClass {
	
	@Test(dependsOnMethods="week3.assignments.UpdateProblemUsingChaining.updateProblem")
	public void deleteProblem()
	{
		response = requestSpecification
		.pathParam("sys_id", sys_ID)
		.delete("{sys_id}")
		.then().assertThat()
		.statusCode(204).extract().response();
	}

}
