package servicenow.changerequest.steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateChangeRequest {
	
	public RequestSpecification requestSpecification;
	public Response response;
		
	/*@Given("Setup the endpoint and URI for the request")
	public void setup_the_endpoint_and_uri_for_the_request() {
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
	}
	
	@Given("Setup the authentication with username as {string} and password as {string}")
	public void setup_the_authentication_with_username_as_and_password_as(String username, String password) {
	   RestAssured.authentication=RestAssured.basic(username, password);
	}*/
	
	@Given("Add the necessary request specification for the request")
	public void add_the_necessary_request_specification_for_the_request() {
		requestSpecification = RestAssured.given().log().all()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON);
	}
	
	@Given("Add body as a file with the filename as {string}")
	public void add_body_as_a_file_with_the_filename_as(String filename) {
	    requestSpecification=requestSpecification.body(new File("./data/"+filename));
	}
	
	@When("Place the request")
	public void place_the_request() {
	    response = requestSpecification.post(); 
	}
	
	@Then("Verify the response status code as {int}")
	public void verify_the_response_status_code_as(Integer statusCode) {
		response = response.then().assertThat().statusCode(statusCode).extract().response();
	}
	
	@Then("Verify the response content Type")
	public void verify_the_response_content_type() {
	    response = response.then().assertThat().contentType(ContentType.JSON).extract().response();
	}
	
	@And("Print the response in the console")
	public void print_the_response_in_the_console()
	{
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
