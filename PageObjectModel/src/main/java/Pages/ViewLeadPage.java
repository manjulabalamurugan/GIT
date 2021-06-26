package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	
	//parameterized constructor is used here to call the driver to all the pages
public ViewLeadPage(ChromeDriver driver)
{
	this.driver = driver;
}
	
	public ViewLeadPage verifyFirstName() {
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("firstName is displayed");
		return this;
		
	}

	public EditLead clickEditButton() throws InterruptedException
	{
		driver.findElement(By.linkText("Edit")).click();
		return new EditLead(driver);
	}
	//driver will be passed to all the constructor
	
	public ViewLeadPage verifyCompanyAfterEditing() throws InterruptedException {
		
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Company name is " +companyName + "- edited with company name");
		return this;
		}
	
	public MyLeadsPage clickDeleteButton() throws InterruptedException
	{
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		return new MyLeadsPage(driver);
	
	}
	
	public FindLeads clickFindLeadslink() throws InterruptedException
	{
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(3000);
		return new FindLeads(driver);
	}
}
