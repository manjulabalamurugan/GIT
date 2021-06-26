package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods  {
	//parameterized constructor is used here to call the driver to all the pages
public CreateLead(ChromeDriver driver)
{
	this.driver = driver;
}


	public CreateLead entercompanyName(String companyName)  throws InterruptedException
	{

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);

		return this;
	}
	
	public CreateLead enterfirstName(String fName) throws InterruptedException
	{Thread.sleep(3000);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		return this;
		
	}
	
	public CreateLead enterlastName(String lName) throws InterruptedException
	{Thread.sleep(3000);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadButton()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}
//driver will be passed to all the constructor
}
