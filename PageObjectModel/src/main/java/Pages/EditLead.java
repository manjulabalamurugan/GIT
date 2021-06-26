package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import testcase.EditLeadTestcase;


public class EditLead extends ProjectSpecificMethods {
	//parameterized constructor is used here to call the driver to all the pages
public EditLead(ChromeDriver driver)
{
	this.driver = driver;
}


	public EditLead enterCompanyName(String companyName) throws InterruptedException
	{	driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
		return this;
	}
	
	public ViewLeadPage clickUpdateButton() throws InterruptedException
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}
	////driver will be passed to all the constructor
}
