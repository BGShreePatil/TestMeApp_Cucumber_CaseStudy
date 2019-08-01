package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features="features\\loginTestMeApp.feature",
			glue="stepDefinition"
		)

public class LoginTestRunner {
	
}
