package servicenow;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewChangeRequestsUsingMultipleFiles {
	
	@DataProvider(name="fetchData")
	public String[] getData()
	{
		String[] data= new String[2];
		data[0] = "./data/CreateChangeRequest1.json";
		data[1] = "./data/CreateChangeRequest2.json";
		
		return data;
	}

	@Test(dataProvider="fetchData")
	public void createNewChangeRequests(String filepath)
	{
		String username="admin";
		String password="wKFaYB7jp2lB";
		
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic(username, password);
		
		Response response = RestAssured.given().log().all()
		.queryParam("sysparm_fields", "number,sys_id,short_description,category,type")
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(new File(filepath))
		.post();
		
		response.prettyPrint();
		
	}
}
