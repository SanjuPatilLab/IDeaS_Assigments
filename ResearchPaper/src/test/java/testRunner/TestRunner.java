package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	
		features = "src/test/java/com/qa/features",
		glue = {"com.qa.StepDefintion"},
		dryRun = false,
		monochrome = true,
		//tags="@error",
		plugin = {"pretty",
				"json:target/jsonReports/cucumber-report.json",
				"junit:target/xmlReports/cucumber-report.xml",
				"html:target/cucumber-reports"
				}	
		
		)




public class TestRunner {

}
