package servicenow.changerequest.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/servicenow/changerequest/features",
		glue = "servicenow.changerequest.steps",monochrome=true)

public class Runner extends AbstractTestNGCucumberTests{

}
