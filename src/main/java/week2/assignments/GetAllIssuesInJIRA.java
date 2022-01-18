package week2.assignments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllIssuesInJIRA extends BaseClass {
	
	@Test
	public void getAllIssues()
	{		
		response = requestSpecification
		.queryParam("jql", "project = \"RA\"")
		.queryParam("maxResults", "20")
		.queryParam("fields", "id,key,description,summary")
		.get("search")
		.then().assertThat().contentType(ContentType.JSON).extract().response();
	}

}
