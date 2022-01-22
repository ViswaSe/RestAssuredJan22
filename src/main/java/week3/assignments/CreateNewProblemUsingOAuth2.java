package week3.assignments;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateNewProblemUsingOAuth2 extends BaseClass {
	
	@Test
	public void createProblem()
	{
		response = requestSpecification	
		.body(new File("./data/createproblem1.json"))
		.post()
		.then().assertThat()
		.statusCode(201)
		.body("result.short_description", Matchers.equalTo("problem created in the rest assured"))
		.extract().response();
		
		sys_ID=response.jsonPath().get("result.sys_id");
	}

}
