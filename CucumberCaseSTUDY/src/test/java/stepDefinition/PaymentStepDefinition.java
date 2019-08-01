package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class PaymentStepDefinition {
	
	WebDriverWait wait;
	WebDriver driver;
	
	@Given("User has Successfully Added Product in to cart")
	public void user_has_Successfully_Added_Product_in_to_cart() {
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

				

	}

	@Given("User is on checkout page")
	public void user_is_on_checkout_page() {
		// Write code here that turns the phrase above into concrete actions
		String text=driver.findElement(By.xpath("//div[@class='col-sm-10'][contains(.,'Headphone')]")).getText();
		driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
	}

	@When("User Proceed to Pay")
	public void user_Proceed_to_Pay() {
		// Write code here that turns the phrase above into concrete actions
		//Click on proceed to pay button
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click(); 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@When("User enters bank credentials {string} {string} {string} {string}")
	public void user_enters_bank_credentials(String bank_name, String bank_username, String bank_Password, String trans_password) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//label[contains(.,'"+bank_name+"')]")).click();
		driver.findElement(By.id("btn")).click(); 
		
		//Enter bank caredentials
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(bank_username); 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(bank_Password); 
 
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click(); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Enter Transaction Password

		driver.findElement(By.xpath("//input[contains(@name,'transpwd')]")).sendKeys(trans_password);
		
		driver.findElement(By.xpath("//input[@type='submit' and value='PayNow']")).click(); 
	

	}

	@Then("Order placed successfully")
	public void order_placed_successfully() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Order placed successfully");
	}

}
