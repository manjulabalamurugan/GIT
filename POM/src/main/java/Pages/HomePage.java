package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethods;

public class HomePage extends base.ProjectSpecificMethods {
	
	//parameterized constructor is used here to call the driver to all the pages
public HomePage(ChromeDriver driver,ExtentTest node)
{
	this.driver = driver;
	this.node = node;
}
		
		
	public LoginPage clicklogoutbutton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new LoginPage(driver,node);
	}
	//driver will be passed to all the constructor
	
	public MyHomePage clickCRMSALink() throws IOException{
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep("crmsfa link is displayed","pass");
		} catch (Exception e) {
			reportStep("crmsfa link is not displayed","fail");
		}
		return new MyHomePage(driver);
	}

}
