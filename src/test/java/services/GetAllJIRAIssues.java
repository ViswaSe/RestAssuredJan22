package services;

import java.util.List;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class GetAllJIRAIssues extends BaseServiceRequest {
	
	@Test
	public void getJIRAIssues()
	{
		response = request.queryParam("jql", "project = \"RA\"")
		.queryParam("fields", "id,key,description,summary")
		.get("search")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.extract().response();
		
		List<String> list=response.jsonPath().getList("issues.fields.summary");
		boolean result=false;
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).contains("Matschie framework"))
			{
				result=true;
				break;
			}
		}
		
		if(result)
		{
			System.out.println("Body assertion verified successfully");
		}
		else
		{
			System.out.println("Body assertion - some fields are missing");
		}
	}
	

}
