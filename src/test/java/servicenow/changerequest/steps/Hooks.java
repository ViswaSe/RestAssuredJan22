package servicenow.changerequest.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {

	@Before
	public void init_serviceNow()
	{
		String username = "admin";
		String password = "wKFaYB7jp2lB";
		
		RestAssured.baseURI = "https://dev61821.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic(username, password);
	}
	
	@After
	public void afterTestRun(Scenario sc)
	{
		System.out.println(sc.getName()+":"+sc.getStatus());
	}
	
}
