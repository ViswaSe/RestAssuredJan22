package steps;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matchers;

import hooks.BaseAPIRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateJIRAIssue extends BaseAPIRequest {
	
	@Given("Add the body file for create using the filename as {string}")
	public void add_the_body_file_for_create_using_the_filename_as(String filename) {
		request = request.body(new File("./data/"+filename));
	}
	
	@Given("Place the request for Post")
	public void place_the_request_for_post() {
		response = request.post("issue");
	}
	
	@Then("Verify the below response from the response body")
	public void verify_the_below_response_from_the_response_body(Map<String,String> dataTable) {
	  
		for(Entry<String,String> eachEntry: dataTable.entrySet())
		{
			response = response.then().assertThat().body(eachEntry.getKey(), Matchers.containsString(eachEntry.getValue())).extract().response();
		}
		
	}

}
