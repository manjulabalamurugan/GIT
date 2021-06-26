package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass{


@Given("Enter the username as {string}")
public void enterUserName(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		
	}
@Given("Enter the password as {string}")	
	public void enterPassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}
@When("Click on Login button")	
	public void clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
@Then("Homepage should be displayed")	
	public void titleverification()
	{String title = driver.getTitle();
	if (title.equalsIgnoreCase("Leaftaps - TestLeaf Automation Platform"))
	{
		System.out.println("Homepage is displayed");
	}
		
	}
/*
 * @But("Error message will be displayed")
public void verifyErrorMessage() {
	System.out.println("Error msg verified");

}
	*/



}
