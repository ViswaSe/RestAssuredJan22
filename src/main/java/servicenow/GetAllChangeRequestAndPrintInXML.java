package servicenow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllChangeRequestAndPrintInXML {
	
	@Test
	public void getAllChangeRequestWithXML()
	{
		String username="admin";
		String password="wKFaYB7jp2lB";
		
		//End point
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		
		//Authentication
		RestAssured.authentication=RestAssured.basic(username, password);
		
		//Sending Request with adding parameters
		Response response = RestAssured.given()
		.accept(ContentType.XML)
		.queryParam("sysparm_fields", "number,sys_id,short_description,category,type")
		.get();
		
		//print the response and status code
		System.out.println(response.statusCode());
		response.prettyPrint();
		
		//print the total size of response value
		XmlPath xmlResponse = response.xmlPath();
		List<String> number_list=xmlResponse.getList("response.result.number");
		System.out.println("Total number of change request: "+number_list.size());
		
	}

}
