package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

		
		public LoginPage(ChromeDriver driver)
		{
			this.driver = driver;
		}

		public LoginPage enterUserName(String username) throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='uid'][1]")).sendKeys(username);
			return this;
	}
	
		public LoginPage enterPassword(String password) throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
			return this;
	}
	
		public ClientsPage clickLoginInButton() throws InterruptedException {
			driver.findElement(By.xpath("(//button[@id='login-button'])[1]")).click();
			Thread.sleep(3000);
			return new ClientsPage(driver);
	}

}
