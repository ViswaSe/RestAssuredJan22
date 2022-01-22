package week3;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GetSpecificChangeRequestUsingOAuthAndValidateSchema {

	@Test
	public void getAllChangeRequest()
	{
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication= RestAssured.oauth2("qLmcvVOLHRx7sQrEtQiXWNuCJ5EieObFdjqgqyKlFb0utsWovi6xyU2i_S7g06wc-DpMYN52slzmy46gsP7lVg");
		
		Response response = RestAssured.given().log().all()
		.get("1766f1de47410200e90d87e8dee490f6")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(new File("./data/get_changerequest_schema.json")))
		.extract().response();
		
		response.prettyPrint();
	}
	
}
