package atlassian.jira.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {
	
	@Before
	public void init_jira()
	{
		String username="vidhyavishveshwar@gmail.com";
		String password="1x4ZpHAzDDP90DoC3WJr0B0B";	
		
		RestAssured.baseURI="https://restapi2022.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic(username, password);
	}
	
	@After
	public void after_testrun(Scenario sc)
	{
		System.out.println(sc.getName()+":"+sc.getStatus());
	}

}
