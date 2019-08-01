package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class LoginStepDefinition {
	WebDriverWait wait;
	static WebDriver driver;
	String username="";
	String passwrd="";
	
	static {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	@Given("User is on home page of TestMeApp application")
	public void user_is_on_home_page_of_TestMeApp_application() {
		// Write code here that turns the phrase above into concrete actions
	

		driver.get("http://10.232.237.143:443/TestMeApp/");
		wait=new WebDriverWait(driver, 30);
	}

	@When("User clicks on Signin Link")
	public void user_clicks_on_Signin_Link() {
		// Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("SignIn")));
		driver.findElement(By.linkText("SignIn")).click();


	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String psw) {
		// Write code here that turns the phrase above into concrete actions
		username=uname;
		passwrd=psw;
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(passwrd);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("Login")).click();
	}

	@Then("User is on Home page with successful Login")
	public void user_is_on_Home_page_with_successful_Login() {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("User Login Successfully");
	}



}
