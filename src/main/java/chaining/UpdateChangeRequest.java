package chaining;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class UpdateChangeRequest extends BaseRequest {
	
	@Test(dependsOnMethods= {"chaining.CreateNewChangeRequest.createNewChangeRequest"})
	public void updateChangeRequest()
	{
		response = requestSpecification.pathParam("sys_id", sys_ID)
					.body(new File("./data/UpdateChangeRequest1.json"))
					.patch("{sys_id}")
					.then().assertThat()
					.statusCode(200)
					.body("result.short_description", Matchers.containsString("Updated")).extract().response();
	}

}
