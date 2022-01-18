package chaining;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateNewChangeRequest extends BaseRequest {
	
	@Test
	public void createNewChangeRequest()
	{
		response = 	requestSpecification
					.body(new File("./data/CreateChangeRequest2.json"))
					.post()
					.then().assertThat().body("result.short_description", Matchers.equalTo("Vishveshwar - Created a new change request (2) from rest assured")).extract().response();
		
		sys_ID=response.jsonPath().get("result.sys_id");
	}

}
