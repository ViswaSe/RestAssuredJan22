package week2.assignments;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateMultipleNewIssuesInJIRA extends BaseClass {
	
	@DataProvider(name="fetchData")
	public Object[] setData()
	{
		String[] data= new String[2];
		data[0] = "./jiraassignmentsdata/createissue1.json";
		data[1] = "./jiraassignmentsdata/createissue2.json";
		return data;
	}
	
	@Test(dataProvider="fetchData")
	public void createMultipleNewIssues(String filePath)
	{		
		response = requestSpecification
					.body(new File(filePath))
					.post("issue")
					.then().assertThat().statusCode(201).extract().response();
	}

}
