package atlassian.jira.steps;

import java.io.File;

import atlassian.jira.hooks.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class JiraIssue_StepDefinition extends BaseClass{
	
	@Given("Create the new issue using the filename as {string}")
	public void create_the_new_issue_using_the_filename_as(String filename) {
	   requestSpecification = requestSpecification.body(new File("./data/jiradata/"+filename));
	}
	
	@Given("Place the request for Create")
	public void place_the_request_for_Create() {
		response = requestSpecification.post();
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
	
	@Given("Get the random number using program using max value as {int}")
	public void get_the_random_number_using_program_using_max_value_as(Integer maxValue) 
	{
		int random_no=(int) Math.floor(Math.random()*(maxValue-10+1)+10);
		randomIssueKey="RA-"+random_no;
	}
	
	@Given("Place the request for Get")
	public void place_the_request_for_get() {
		response = requestSpecification.pathParam("issue_key", randomIssueKey)
				.get("{issue_key}");
	}
}
