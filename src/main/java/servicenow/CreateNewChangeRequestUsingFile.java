package servicenow;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewChangeRequestUsingFile {
	
	@Test
	public void createNewChangeRequest()
	{
		String username="admin";
		String password="wKFaYB7jp2lB";
		
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic(username, password);
		
		Response response = RestAssured.given().log().all()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.queryParam("sysparm_fields", "number,sys_id,category,short_description,type")
		.body(new File("./data/CreateChangeRequest1.json"))
		.post();
		
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	}

}
