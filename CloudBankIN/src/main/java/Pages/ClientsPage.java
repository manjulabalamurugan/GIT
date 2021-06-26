package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.ProjectSpecificMethods;

public class ClientsPage extends ProjectSpecificMethods {
	
	static String clientID;
		public ClientsPage(ChromeDriver driver)
		{
			this.driver = driver;
		}
		
		public ClientsPage moveToClientsDropdown(String clientsDropDown) throws InterruptedException  {
			
			Actions action = new Actions(driver);
			WebElement Clients = driver.findElement(By.id("client-dropdown"));
			action.moveToElement(Clients).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[contains(text(),"+clientsDropDown+")]")).click();
			return this;
		}
		
		public CreateClientPage clickCreateClient() {
			driver.findElement(By.xpath("//a[@id='client_createbutton']")).click();
			return new CreateClientPage(driver);
}
		
		public void enterClientID() throws InterruptedException {
			Thread.sleep(2000);	
			driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(clientID,Keys.ENTER);
			String VerifyClientID = driver.findElement(By.xpath("//tr[@class='pointer-main ng-scope']//td[contains(text(),"+clientID+")]")).getText();
			System.out.println("Found ClientID :  " + VerifyClientID);
			
			if(clientID.equalsIgnoreCase(VerifyClientID))
			{
				System.out.println("Client ID matched & client info created successfully");
			}


		}
}
