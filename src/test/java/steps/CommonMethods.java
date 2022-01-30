package steps;

import hooks.BaseAPIRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CommonMethods extends BaseAPIRequest{
	
	@Given("Add the necessary request specification")
	public void add_the_necessary_request_specification() {
	    request=RestAssured.given().log().all()
	    		.accept(ContentType.JSON)
	    		.contentType(ContentType.JSON);
	}

	@Then("Verify the status code as {int}")
	public void verify_the_status_code_as(Integer expectedStatusCode) {
	    response = response.then().assertThat().statusCode(expectedStatusCode).extract().response();
	}
	
	@Then("Verify the content type of the response")
	public void verify_the_content_type_of_the_response() {
	    response = response.then().assertThat().contentType(ContentType.JSON).extract().response();
	}

	@Then("Print the response body with status code")
	public void print_the_response_body_with_status_code() {
	    	response.prettyPrint();
	    	System.out.println(response.statusCode());
	}
	
	@Then("Capture the issue key from the response")
	public void capture_the_issue_key_from_the_response() {
	    issueKey=response.jsonPath().get("key");
	}
}
