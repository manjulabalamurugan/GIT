package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	
	//parameterized constructor is used here to call the driver to all the pages
public HomePage(ChromeDriver driver)
{
	this.driver = driver;
}
		
		
	public LoginPage clicklogoutbutton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new LoginPage(driver);
	}
	//driver will be passed to all the constructor
	
	public MyHomePage clickCRMSALink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);
	}

}
