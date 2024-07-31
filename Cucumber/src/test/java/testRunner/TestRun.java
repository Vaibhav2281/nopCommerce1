package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(
		//features = {".//features/Customers.feature", ".//features/Login.feature"},
		features = ".//features/Customers.feature",
		glue = "stepDefinitions",      //folder as well as file can be used
		dryRun = false,               //true is set to check dry run
		monochrome = true,			  //the output generated becomes readable
		tags = "@sanity",             //used to run specific scenarios
		plugin = {"pretty","html:test-output"}
	)

public class TestRun {

}
