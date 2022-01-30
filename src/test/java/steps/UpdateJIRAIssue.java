package steps;

import java.io.File;

import hooks.BaseAPIRequest;
import io.cucumber.java.en.Given;

public class UpdateJIRAIssue extends BaseAPIRequest{
	
	@Given("Add the body file for update using the filename as {string}")
	public void add_the_body_file_for_update_using_the_filename_as(String filename) {
	    request = request.body(new File("./data/"+filename));
	}
	
	@Given("Place the request for Put")
	public void place_the_request_for_put() {
		response = request.pathParam("issue_key", issueKey)
					.put("issue/{issue_key}");
	}
	
}
