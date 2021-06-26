package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClass{
	@Given("Enter1 the username as {string}")
	public void enterUserName(String username)
		{
			driver.findElement(By.id("username")).sendKeys(username);
			
		}
	@Given("Enter1 the password as {string}")	
		public void enterPassword(String password)
		{
			driver.findElement(By.id("password")).sendKeys(password);
		}
	@When("Click1 on Login button")	
		public void clickLogin()
		{
			driver.findElement(By.className("decorativeSubmit")).click();
		}
	@Then("Homepage must be displayed")
	public void titleverification() {
	    String title = driver.getTitle();
	    if(title.equals("My Home | opentaps CRM"))
	    {
	    	System.out.println("Home page is verified");
	    }
	}
	@When("Click on crmsfa link")
	public void clikOnCrmsfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@Then("My Homepage should be displayed")
	public void myHomepageShouldBeDisplayed() {
	    String title = driver.getTitle();
	    if(title.equals("My Home | opentaps CRM"))
	    {
	    	System.out.println(title);
	    }
	}
	@When("Click on leads link")
	public void clickOnLeadsLink() {
		driver.findElement(By.linkText("Leads")).click();

}}

