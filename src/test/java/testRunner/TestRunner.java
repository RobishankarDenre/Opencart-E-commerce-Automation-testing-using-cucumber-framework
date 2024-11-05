package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features = {".//features/"},
		features = { ".//features/login.feature" },
//		features= {".//features/Registration.feature"},
//		features = { ".//features/Registration.feature", ".//features/login.feature" },
//		features = {"@target/rerun.txt"},

		glue = {"stepsDefinitions","hooks"},
		plugin = { "pretty", "html:reports/myreport.html",
//				"rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
		dryRun = false, 
		monochrome = true, 
		publish = true

)
public class TestRunner {

}
