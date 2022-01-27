package atlassian.jira.steps;

import org.hamcrest.Matchers;

import atlassian.jira.hooks.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JiraIssue_CommonMethods extends BaseClass{
	
	@Given("Add the necessary request specification")
	public void add_the_necessary_request_specification() {
	   		requestSpecification=RestAssured.given().log().all()
	   							.accept(ContentType.JSON)
	   							.contentType(ContentType.JSON);
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
	

}
