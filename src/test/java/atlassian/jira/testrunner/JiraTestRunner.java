package atlassian.jira.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/atlassian/jira/features/jira.feature",
		glue="atlassian.jira.steps",monochrome=true,
		tags="@regression")

public class JiraTestRunner extends AbstractTestNGCucumberTests{

}
