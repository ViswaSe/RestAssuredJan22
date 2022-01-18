package chaining;

import org.testng.annotations.Test;

public class DeleteChangeRequest extends BaseRequest {

	@Test(dependsOnMethods= {"chaining.UpdateChangeRequest.updateChangeRequest"})
	public void deleteChangeRequest()
	{
		response = requestSpecification.pathParam("sys_id",sys_ID)
		.delete("{sys_id}")
		.then().assertThat().statusCode(204).extract().response();
	}
}
