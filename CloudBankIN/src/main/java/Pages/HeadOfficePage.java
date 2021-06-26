package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class HeadOfficePage extends ProjectSpecificMethods {

		static String clientID;
		
		public HeadOfficePage(ChromeDriver driver)
		{
			this.driver = driver;

}
		public ActivatePage clickActivateButton() {
			
			
			
			driver.findElement(By.linkText("Activate")).click();
			return new ActivatePage(driver);
		}
		
		public ClientsPage verifyActivatedClientAccount() {
			String clientText = driver.findElement(By.xpath("//small[@class='ng-binding']")).getText();
			clientID = clientText.replaceAll("\\D","");
			System.out.println("Generated ClientID : " +clientID);
			
			return new ClientsPage(driver);

		}
}