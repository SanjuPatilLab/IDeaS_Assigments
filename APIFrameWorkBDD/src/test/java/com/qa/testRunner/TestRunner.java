package com.qa.testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/java/com/qa/features",
		glue = {"com.qa.stepDefinitions"},
		//tags="@DeletePlace",
		dryRun = false,
		plugin = {"pretty",
				"json:target/jsonReports/cucumber-report.json",
				"junit:target/xmlReports/cucumber-report.xml",
				"html:target/cucumber-reports"
				},
		monochrome= true
		
				
		)

public class TestRunner {

}
