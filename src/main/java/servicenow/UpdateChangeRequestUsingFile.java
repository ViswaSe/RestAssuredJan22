package servicenow;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateChangeRequestUsingFile {
	
	@Test
	public void updateChangeRequest()
	{
		String username="admin";
		String password="wKFaYB7jp2lB";
		
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic(username, password);
		
		Response response = RestAssured.given().log().all()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(new File("./data/UpdateChangeRequest1.json"))
		.pathParam("sys_id", "245d4ec687050110f69663150cbb3547")
		.patch("{sys_id}");
		
		System.out.println(response.statusCode());
		
		response.prettyPrint();
	}
	

}
