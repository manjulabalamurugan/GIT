package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	//parameterized constructor is used here to call the driver to all the pages
public LoginPage(ChromeDriver driver)
{
		this.driver = driver;
}
	
	
		public LoginPage enterUsername(String username)
		{
			driver.findElement(By.id("username")).sendKeys(username);
			return this;
		}
		
		public LoginPage enterPassword(String password)
		{
			driver.findElement(By.id("password")).sendKeys(password);
			return this;
			
		}
		
		public HomePage clickLoginButton()
		{
			driver.findElement(By.className("decorativeSubmit")).click();
			return new HomePage(driver);
		}
		
		//driver will be passed to all the constructor
}


