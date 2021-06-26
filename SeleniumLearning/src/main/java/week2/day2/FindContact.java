package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {

	public FindContact() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException  {
		
		//Pseudo Code
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		 driver.get("http://leaftaps.com/opentaps/control/login" );
		//Enter UserName and Password Using Id Locator
		 driver.findElementById("username").sendKeys("democsr");
		 driver.findElementById("password").sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		 driver.findElementByClassName("decorativeSubmit").click();
		//Click on CRM/SFA Link
		 driver.findElementByLinkText("CRM/SFA").click();
		//Click on contacts Button
		 driver.findElementByLinkText("Contacts").click();
		//Click on Find Contacts
		 driver.findElementByLinkText("Find Contacts").click();
		// Click on the Email Field using Xpath Locator
		//Enter the email using any locator
		 driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("vidhyalakshmi029@gmail.com");
		
		//Click on Find Contacts using Xpath Locator
		 driver.findElementByXPath("//button[contains(text(),'Find Contacts')]").click();
		 Thread.sleep(5000);
		// Click on the First Resulting Contact
		
		 driver.findElementByXPath("(//a[@href='/crmsfa/control/viewContact?partyId=10002'])[1]").click();
		//Get the Text of First Name 
		
		
		String element1 = driver.findElementByXPath("(//span[@id='viewContact_firstName_sp'])[1]").getText();
		System.out.println(element1);
		
		//driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]").click();
		// Click on the Edit Button
	
		driver.findElementByXPath("//a[@href='/crmsfa/control/updateContactForm?partyId=10002']").click();	
		//Select New Marketing Campaign as eCommerce Site Internal Campaign by using SelectByValue
		
		 WebElement findElementByXPath = driver.findElementByXPath("//select[@name='marketingCampaignId']");
		Select element = new Select(findElementByXPath);
		element.selectByValue("eCommerce Site Internal Campaign");
		// Click on the add button
		driver.findElementByXPath("(//input[@class='smallSubmit'])[2]").click();	
		// Enter Department Value as Selenium Automation Testing

		// Click on the Update Button

		// Get the text of Marketing campaign and Verify it
		 
		//verify Title of the Current page
		
	}

}
