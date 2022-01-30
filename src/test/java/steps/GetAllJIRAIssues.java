package steps;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matchers;

import hooks.BaseAPIRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GetAllJIRAIssues extends BaseAPIRequest{

	@Given("Add the necessary query parameters")
	public void add_the_necessary_query_parameters() {
		request = request
				.queryParam("jql", "project = \"RA\"")
				.queryParam("fields", "issue,key,description,summary");
	}
	
	@When("Place the request for Get")
	public void place_the_request_for_get() {
		response = request.get("search");
	}
	
	@And("Verify the below response validations")
	public void verify_the_below_response_validations(Map<String,String> datatable)
	{
		int size = response.jsonPath().getList("issues.key").size();
		
		for(int i=0;i<size;i++)
		{
			for(Entry<String,String> eachEntry:datatable.entrySet())
			{
				response.then().assertThat().body("issues["+i+"]."+eachEntry.getKey(), Matchers.containsString(eachEntry.getValue()));
			}
		}
	}
}
