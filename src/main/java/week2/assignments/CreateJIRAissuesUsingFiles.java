package week2.assignments;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateJIRAissuesUsingFiles extends BaseClass {
	
	static int iteration_no=1;

	@DataProvider(name="fetchData")
	public Object[] getData()
	{
		String[] data = new String[2];
		data[0] = "./jiraassignmentsdata/createissue4.json";
		data[1] = "./jiraassignmentsdata/createissue5.json";
		
		return data;
	}
	
	@Test(dataProvider="fetchData")
	public void createJIRAissues(String filePath)
	{
		response = requestSpecification
		.body(new File(filePath))
		.post("issue")
		.then().assertThat()
		.statusCode(201)
		.body("key", Matchers.containsString("RA"))
		.contentType(ContentType.JSON).extract().response();
		
		if(iteration_no<=1)
		{
			issueKey=response.jsonPath().get("key");
			iteration_no++;
		}
	}
	
}
