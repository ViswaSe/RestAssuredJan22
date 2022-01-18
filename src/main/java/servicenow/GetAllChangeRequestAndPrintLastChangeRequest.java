package servicenow;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllChangeRequestAndPrintLastChangeRequest {

	@Test
	public void getAllChangeRequest()
	{
		String username = "admin";
		String password = "wKFaYB7jp2lB";
		
		//End point & Resources
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		
		//Authentication
		RestAssured.authentication=RestAssured.basic(username, password);
		
		//Request Type
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "number,short_description,sys_id,type,category")
		.get()
		.then().assertThat().body("result.number", Matchers.hasItem("CHG0030051")).extract().response();
		
		//Print the response & status code
		System.out.println(response.statusCode());
		response.prettyPrint();
		
		//Print the last change request number & sys_id
		JsonPath jsonResponse = response.jsonPath();
		List<String> number_list=jsonResponse.getList("result.number");
		String last_number = number_list.get(number_list.size()-1);
		System.out.println(last_number);
		
	}
	
}
