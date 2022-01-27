package atlassian.jira.hooks;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static RequestSpecification requestSpecification;
	public static Response response;
	public static String issueKey,randomIssueKey;

}
