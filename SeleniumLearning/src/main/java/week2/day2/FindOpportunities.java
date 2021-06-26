package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOpportunities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			/*
			 * //Pseudo Code
			 * 
			 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
			 * 
			 * 2. Enter UserName and Password Using Xpath Locator
			 * 
			 * 3. Click on Login Button using Xpath Locator
			 * 
			 * 4. Click on CRM/SFA Link
			 * 
			 * 5. Click on Oppurtunites Button
			 * 
			 * 6. Click on Find Oppurtunites using Xpath Locator
			 * 
			 * 7. Get the List of Oppurtunites available in Oppurtunity id usinf Xpath Locator
			 * 
			 * 8. Get the Title of the Page and verify it.
			 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Enter UserName and Password Using Xpath Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on Oppurtunites Button
		driver.findElement(By.linkText("Opportunities")).click();
		//Click on Find Oppurtunites using Xpath Locator
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findOpportunities']")).click();
		//Get the List of Oppurtunites available in Oppurtunity id usinf Xpath Locator	
		 java.util.List<WebElement> opportunities = driver.findElements(By.xpath("//div[@class='x-grid3-scroller']//td[2]/div"));
			System.out.println(opportunities.size());
			
			for (WebElement eachopportunities : opportunities) {
				System.out.println(eachopportunities.getText());
				
			}
		
		
		
		
		
		
		
		
	}

}
