package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features\\PaymentProcess.feature",
		glue="stepDefinition",
		plugin="json:target/cucumber-reports/cucumberReports.json"
		)

public class PaymentTestRunner {

}
