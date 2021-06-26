package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {
	
	//parameterized constructor is used here to call the driver to all the pages
public MyHomePage(ChromeDriver driver)
{
	this.driver = driver;
}

	
	
	public MyLeadsPage clickLeadsLink()  throws InterruptedException
	{
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
		return new MyLeadsPage(driver);
	}
	//driver will be passed to all the constructor
	
}
