package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import io.cucumber.java.en.*;

public class SearchProductStepDef {
	WebDriverWait wait;
	WebDriver driver;
	@Given("User is on home page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("1");
	   System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
		driver=new ChromeDriver();

		driver.get("http://10.232.237.143:443/TestMeApp/");
		wait=new WebDriverWait(driver, 30);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("SignIn")));
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("BgsHREE");
		driver.findElement(By.id("password")).sendKeys("bgs123456");
		driver.findElement(By.name("Login")).click();
		
		

	}

	@When("User searched for the product")
	public void user_searched_for_the_product() {
	    // Write code here that turns the phrase above into concrete actions
		  System.out.println("2");
		  Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.name("products")));
			driver.findElement(By.name("products")).click();
			act.sendKeys("H").pause(2000).sendKeys("e").pause(1000).sendKeys("a").pause(1000).sendKeys("d").build().perform();
			driver.findElement(By.xpath("(//div[contains(.,'Headphone')])[4]")).click();


			driver.findElement(By.xpath("//input[@type='submit']")).click();
			String product=driver.findElement(By.xpath("//h4[contains(.,'Headphone')]")).getText();

			//check same product diplaying as searched
			

			driver.findElement(By.xpath("//a[@href='#'][contains(.,'Add to cart')]")).click();
			driver.findElement(By.partialLinkText("Cart")).click();

			String text=driver.findElement(By.xpath("//div[@class='col-sm-10'][contains(.,'Headphone')]")).getText();

			
	}

	@When("USer clicks on Find Details button")
	public void user_clicks_on_Find_Details_button() {
	    // Write code here that turns the phrase above into concrete actions
		  System.out.println("3");
	}

	@Then("User is succesfully redirect to product detail page of searched product")
	public void user_is_succesfully_redirect_to_product_detail_page_of_searched_product() {
	    // Write code here that turns the phrase above into concrete actions
		  System.out.println("4");
	}

}
