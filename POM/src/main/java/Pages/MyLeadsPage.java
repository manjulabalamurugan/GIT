package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods  {
	
	//parameterized constructor is used here to call the driver to all the pages
public MyLeadsPage(ChromeDriver driver)
{
		this.driver = driver;
}
	
	public CreateLead clickCreateLeadsLink()  throws InterruptedException
	{
		driver.findElement(By.linkText("Create Lead")).click();
		Thread.sleep(3000);
		return new CreateLead(driver);
	}
	
	public FindLeads clickFindLeadslink() throws InterruptedException
	{
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(3000);
		return new FindLeads(driver);
	}
	//driver will be passed to all the constructor
	public MergeLead clickMergeLeadLink(){
		driver.findElement(By.linkText("Merge Leads")).click();
		return new MergeLead();
	}
	}
