package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features="features\\SearchProduct.feature",
			glue="stepDefinition"
		)
public class SearchProductTestRunner {

}
