package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewChangeRequest {
	
	public RequestSpecification requestSpecification;
	public Response response;
	
	@Given("Setup the Endpoint and URI")
	public void setup_Endpoint()
	{
		RestAssured.baseURI="https://dev61821.service-now.com/api/now/table/change_request";
	}
	
	@And("Set the authentication with username as {string} and password as {string}")
	public void setup_Authentication(String username,String password)
	{
		RestAssured.authentication=RestAssured.basic(username,password);
	}
	
	@When("Add all the required request specification")
	public void add_all_the_required_request_specification() {
		requestSpecification = RestAssured.given().log().all()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON);
	}
	
	@And("Add the request body as {string}")
	public void add_the_RequestBody(String filename)
	{
		requestSpecification = requestSpecification.body(new File("./data/"+filename));
	}
	
	@When("Place the request")
	public void place_the_request() {
		response = requestSpecification.post();
		
	}
	@Then("Verify the status code of the response as {int}")
	public void verify_the_status_code_of_the_response(int statuscode) {
	    response.then().assertThat().statusCode(statuscode);
	}
	
	@Then("Verify the content type of the response")
	public void verify_the_content_type_of_the_response() {
		response.then().assertThat().contentType(ContentType.JSON);
	}
	
	@Then("Print the response and status code")
	public void printResponse_StatusCode()
	{
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

}
