package atlassian.jira.steps;

import java.io.File;

import org.hamcrest.Matchers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class jiraissue_stepdefinition {
	
	public static RequestSpecification requestSpecification;
	public static Response response;
	public static String issueKey;
	
	@Given("Add the necessary request specification")
	public void add_the_necessary_request_specification() {
	   		requestSpecification=RestAssured.given().log().all()
	   							.accept(ContentType.JSON)
	   							.contentType(ContentType.JSON);
	}
	
	@Given("Create the new issue using the filename as {string}")
	public void create_the_new_issue_using_the_filename_as(String filename) {
	   requestSpecification = requestSpecification.body(new File("./data/jiradata/"+filename));
	}
	
	@Given("Place the request for Create")
	public void place_the_request_for_Create() {
		response = requestSpecification.post();
	}
	
	@Given("Verify the status code as {int}")
	public void verify_the_status_code_as(Integer statusCode) {
	    response = response.then().assertThat().statusCode(statusCode).extract().response();
	}
	
	@Given("Verify the content type of the response")
	public void verify_the_content_type_of_the_response() {
	    response = response.then().assertThat().contentType(ContentType.JSON).extract().response();
	}
	
	@Given("Verify the response body contains the string as {string}")
	public void verify_the_response_body_contains_the_string_as(String expectedString) {
	    response = response.then().assertThat().body("key", Matchers.containsString(expectedString)).extract().response();
	}
	
	@Given("Print the response body with status code")
	public void print_the_response_body_with_status_code() {
	    response.prettyPrint();
	    System.out.println(response.statusCode());
	}
	
	@And("Get the issue key from the response")
	public void get_the_issue_key_from_the_response()
	{
		 issueKey=response.jsonPath().get("key");
	}
	
	@Given("Update the new issue using the filename as {string}")
	public void update_the_new_issue_using_the_filename_as(String filename) {
		requestSpecification = requestSpecification.body(new File("./data/jiradata/"+filename));
	}
	
	@Given("Place the request for Update")
	public void place_the_request_for_Update() {
		response = requestSpecification
				.pathParam("issue_key", issueKey)
				.put("{issue_key}");
	}
	
	@When("Place the request for Delete")
	public void place_the_request_for_delete()
	{
		response = requestSpecification.pathParam("issue_key", issueKey)
		.delete("{issue_key}");
	}	

}
