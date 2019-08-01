package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.*;

public class RegisterStepDefinition 
{
	WebDriver driver;
	TestMeAppOR objRep;
	@Given("TestMeaApp home page is open")
	public void testmeaapp_home_page_is_open() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","resources\\chromedriver1.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		objRep=new TestMeAppOR(driver);
	}

	@When("Click on SignUP button")
	public void click_on_SignUP_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement signup=objRep.sign_Up;
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.textToBePresentInElement(signup, "SignUp"));
		signup.click();
	}

	@When("Enter {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enter(String uname, String firstname, String lastname, String password, String gender, String email, String mobile, String dob, String address, String question, String ans) {
	    // Write code here that turns the phrase above into concrete actions
  driver.findElement(By.name("userName")).sendKeys(uname);
		  
		  driver.findElement(By.name("firstName")).sendKeys(firstname);
		  
		 String status= driver.findElement(By.id("err")).getText();
		// Thread.sleep(5000);
		// Assert.assertEquals(status, "Available","UserName Is not Available");
		  driver.findElement(By.name("lastName")).sendKeys(lastname);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("confirmPassword")).sendKeys(password);
		  
		  driver.findElement(By.xpath("//input[@name='gender' and @value='"+gender+"']")).click();
		  driver.findElement(By.id("emailAddress")).sendKeys(email);
		  driver.findElement(By.id("mobileNumber")).sendKeys(mobile);
		  driver.findElement(By.id("dob")).sendKeys(dob);
		  driver.findElement(By.id("address")).sendKeys(address);
		  
		  WebElement que=driver.findElement(By.id("securityQuestion"));
		  
		  Select securityQue=new Select(que);
		  securityQue.selectByVisibleText(question);
		  driver.findElement(By.id("answer")).sendKeys(ans);
		  driver.findElement(By.name("Submit")).click();
	}


	@Then("I verify the <status> in step")
	public void i_verify_the_status_in_step() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User Registered successfully");
	}
}
