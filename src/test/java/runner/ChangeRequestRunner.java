package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/ChangeRequest.feature",
	glue="steps",monochrome=true)

public class ChangeRequestRunner extends AbstractTestNGCucumberTests{

}
