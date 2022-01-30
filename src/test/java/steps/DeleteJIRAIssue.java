package steps;

import hooks.BaseAPIRequest;
import io.cucumber.java.en.When;

public class DeleteJIRAIssue extends BaseAPIRequest{
	
	@When("Place the request for Delete")
	public void place_the_request_for_delete() {
		response = request.pathParam("issue_key", issueKey)
		.delete("issue/{issue_key}");
	}

}
