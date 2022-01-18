package servicenow;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteChangeRequestUsingPathParam {
	
	@Test
	public void updateChangeRequest()
	{
		String username="admin";
		String password="wKFaYB7jp2lB";
		
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic(username, password);
		
		Response response = RestAssured.given().log().all()
		.pathParam("sys_id", "245d4ec687050110f69663150cbb3547")
		.delete("{sys_id}");
		
		System.out.println(response.statusCode());
		
		response.prettyPrint();
	}
	

}
