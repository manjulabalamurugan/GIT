package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeads {

/*
 * Application : http://leaftaps.com/opentaps/control/main

1. Launch the browser
2. Enter the username
3. Enter the password
4. Click Login
5. Click crm/sfa link
6. Click Leads link
7. Click Merge leads
8. Click on Icon near From Lead
9. Move to new window
10. Enter Lead ID
11. Click Find Leads button
12. Click First Resulting lead
13. Switch back to primary window
14. Click on Icon near To Lead
15. Move to new window
16. Enter Lead ID
17. Click Find Leads button
18. Click First Resulting lead
19. Switch back to primary window
20. Click Merge
21. Accept Alert
22. Click Find Leads link
23. Enter From Lead ID
24. Click Find Leads button
25. Verify message "No records to display" in the Lead List. This message confirms that the successful merge of leads
26. Close the browser (Do not log out)
 */

	public static void main(String[] args)throws InterruptedException {

		
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			ChromeDriver driver=new ChromeDriver();
// load url
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.manage().window().maximize();
// implicitwait
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			
			driver.findElementById("username").sendKeys("democsr");
			 driver.findElementById("password").sendKeys("crmsfa");
			
//Click on Login Button using Class Locator
			 driver.findElementByClassName("decorativeSubmit").click();
//Click on CRM/SFA Link
			 driver.findElementByLinkText("CRM/SFA").click();
			
//Click Contacts link
			 driver.findElementByLinkText("Contacts").click();
//Click Merge Contacts
			 Thread.sleep(2000);
			 driver.findElementByLinkText("Merge Contacts").click();
//Click on Icon near From Contacts
			 driver.findElementByXPath("(//span[text()='From Contact']/following::img)[1]").click();
			 
//Move to new window
			 Set<String> windows=driver.getWindowHandles();
				List<String> listwindows=new ArrayList<String>(windows);
				driver.switchTo().window(listwindows.get(1));
			 
//Enter Contacts ID
				
				driver.findElementByName("id").sendKeys("10461");
//Click Find Contacts button			 
			 driver.findElementByXPath("//button[text()='Find Contacts']").click();
			 Thread.sleep(5000);
//Click First Resulting Contacts
			// Thread.sleep(2000);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 WebElement element = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]");
			 //wait.until(ExpectedConditions.visibilityOf(element));
			 js.executeScript("arguments[0].click();",element);
			 //driver.findElementByLinkText("10014").click();
//Switch back to primary window
			
			 driver.switchTo().window(listwindows.get(0));
//Click on Icon near To Contacts
			 driver.findElementByXPath("(//span[text()='From Contact']/following::img[@alt='Lookup'])[2]").click();
			 
//Move to new window
			 Set<String> windows1=driver.getWindowHandles();
			List<String> listwindows1=new ArrayList<String>(windows1);
			 driver.switchTo().window(listwindows1.get(1));
				//String windowID = driver.getWindowHandle();
				//driver.switchTo().window(windowID);
// Enter Contacts ID
				Thread.sleep(1000);
				WebElement element1 = driver.findElementByXPath("(//div//label[text()='Contact Id:']/following::input)[1]");
				 wait.until(ExpectedConditions.visibilityOf(element1));
			 driver.findElementByXPath("(//div//label[text()='Contact Id:']/following::input)[1]").sendKeys("10446");
//Click Find Contacts button
			 driver.findElementByXPath("//button[text()='Find Contacts']").click();
//Click First Resulting Contacts
			 WebElement linktext =driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]");
			 js.executeScript("arguments[0].click();",linktext);
//Switch back to primary window
			 driver.switchTo().window(listwindows1.get(0));
//Click Merge	 
			 
			 driver.findElementByLinkText("Merge").click();
			 driver.switchTo().alert().accept();
			 
//close browser			 
			 
			 driver.close();
			 
			 
			 
			 
			 
			 
			 
			 
	}

}
