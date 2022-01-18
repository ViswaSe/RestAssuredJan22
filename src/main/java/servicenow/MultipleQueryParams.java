package servicenow;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MultipleQueryParams {
	
	@Test
	public void tryMultipleQueryParams()
	{
		String username="admin";
		String password="wKFaYB7jp2lB";
		
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic(username, password);
		
		Map<String,String> queryParams=new HashMap<String,String>();
		queryParams.put("accept", "application/json");
		queryParams.put("Content-Type", "application/json");
		queryParams.put("sysparm_fields", "number,short_description,type,category,sys_id");
		queryParams.put("sysparm_limit", "2");
		
		Response response = RestAssured.given().log().all()
		.queryParams(queryParams)
		.get();
		
		response.prettyPrint();
	}

}
