package bddRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/bddFeatures", 
		glue = { "bddSteps" },
		dryRun = true
		)
public class TestRunner {

}
