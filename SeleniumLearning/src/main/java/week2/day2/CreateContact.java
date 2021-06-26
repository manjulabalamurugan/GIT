package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

		public static void main(String[] args) {
			
			/*
			 * //Pseudo Code
			 * 
			 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
			
			
			 * 
			 * 2. Enter UserName and Password Using Id Locator
			 * 
			 * 3. Click on Login Button using Class Locator
			 * 
			 * 4. Click on CRM/SFA Link
			 * 
			 * 5. Click on contacts Button
			 * 
			 * 6. Click on Create Contact
			 *  
			 * 7. Enter FirstName Field Using id Locator
			 * 
			 * 8. Enter LastName Field Using id Locator
			 * 
			 * 9. Enter FirstName(Local) Field Using id Locator
			 * 
			 * 10. Enter LastName(Local) Field Using id Locator
			 * 
			 * 11. Enter Department Field Using any Locator of Your Choice
			 * 
			 * 12. Enter Description Field Using any Locator of your choice 
			 * 
			 * 13. Enter your email in the E-mail address Field using the locator of your choice
			 * 
			 * 14. Select State/Province as NewYork Using Visible Text
			 * 
			 * 15. Click on Create Contact
			 * 
			 * 16. Click on edit button 
			 * 
			 * 17. Clear the Description Field using .clear
			 * 
			 * 18. Fill ImportantNote Field with Any text
			 * 
			 * 19. Click on update button using Xpath locator
			 * 
			 * 20. Get the Title of Resulting Page.
	         */
			
			
			
			WebDriverManager.chromedriver().setup();
			
			
			
			WebDriverManager.chromiumdriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login" );
			driver.manage().window().maximize();
			
			//Enter UserName and Password Using Id Locator
			driver.findElementById("username").sendKeys("DemoSalesManager");
			
			driver.findElementById("password").sendKeys("crmsfa");
			driver.findElementByClassName("decorativeSubmit").click();
			//Click on CRM/SFA Link
			driver.findElement(By.linkText("CRM/SFA")).click();
			//Click on contacts Button
			driver.findElement(By.linkText("Contacts")).click();
			//Click on Create Contact
			
			driver.findElement(By.linkText("Create Contact")).click();
			
			//Enter FirstName Field Using id Locator
					driver.findElementById("firstNameField").sendKeys("manjula");
			
			//Enter LastName Field Using id Locator
					driver.findElementById("lastNameField").sendKeys("balamurugan");
			//Enter FirstName(Local) Field Using id Locator
					driver.findElementById("createContactForm_firstNameLocal").sendKeys("manju");
			//Enter LastName(Local) Field Using id Locator
					driver.findElementById("createContactForm_lastNameLocal").sendKeys("balu");
					
			//Enter Department Field Using any Locator of Your Choice
					driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
			
			//Enter your email in the E-mail address Field using the locator of your choice
					driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("manju@gmail.com");
					
			//Select State/Province as NewYork Using Visible Text
					WebElement state=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
					Select s1=new Select(state);
					s1.selectByVisibleText("New York");
			//Click on Create Contact
					driver.findElement(By.className("smallSubmit")).click();
			//Click on edit button 
			driver.findElement(By.linkText("Edit")).click();
			//Clear the Description Field using .clear
			driver.findElement(By.id("updateContactForm_description")).clear();
			//Fill ImportantNote Field with Any text
			
			driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("find me");
			//Click on update button using Xpath locator
			
			
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			//Get the Title of Resulting Page.
			String title1 = driver.getTitle();
			System.out.println(title1);
			
			//driver.findElement(By.className("importantNote")).sendKeys("I recently joined here");
			//driver.findElement(By.className("description ")).sendKeys("I recently joined here");
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

	
	

}
