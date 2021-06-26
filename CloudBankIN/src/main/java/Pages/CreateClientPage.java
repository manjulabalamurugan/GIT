package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class CreateClientPage extends ProjectSpecificMethods {
	static String officeDropdown;
	
	
	public CreateClientPage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	public CreateClientPage officeDropdown(String officeDropdown) throws InterruptedException {
		Actions action2 = new Actions(driver);
		WebElement office = driver.findElement(By.id("officeId_chosen"));
		action2.moveToElement(office).click().sendKeys(officeDropdown,Keys.ENTER).perform();
		return this; 
	}
	public CreateClientPage genderDropDown(String genderDropDown) throws InterruptedException {
		Actions action4 = new Actions(driver);
		WebElement gender = driver.findElement(By.id("genderId_chosen"));
		action4.moveToElement(gender).click().sendKeys(genderDropDown,Keys.ENTER).perform();
		Thread.sleep(1000);
		
		return this;
	}
	public CreateClientPage clientTypeDropdown(String clientTypeDropdown) throws InterruptedException{
		Actions action3 = new Actions(driver);
		WebElement clientType = driver.findElement(By.id("clienttypeId_chosen"));
		action3.moveToElement(clientType).click().sendKeys(clientTypeDropdown,Keys.ENTER).perform();
		Thread.sleep(1000);
		
		return this;
	}
	public CreateClientPage clientClassificationDropdown(String clientClassificationDropdown) throws InterruptedException {
		Actions action5 = new Actions(driver);
		WebElement clientClassification = driver.findElement(By.id("clientClassificationId_chosen"));
		action5.moveToElement(clientClassification).click().sendKeys(clientClassificationDropdown,Keys.ENTER).perform();
		Thread.sleep(1000);
		return this;
	}
	public CreateClientPage enterFirstName(String FirstName) {
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(FirstName);
		
		String clientName = driver.findElement(By.xpath("//input[@id='firstname']")).getText();
		char[] y = clientName.toCharArray();
		int size = clientName.length();
		
		int i=0;
		while(i!=size)
		{
			if(y[i]>='0' && y[i] <= '9')
			{	
				String firstNameAndLastNameErrorMessage = driver.findElement(By.xpath("//span//small[@class='error required ng-binding']")).getText();
				System.out.println("Invalid data given for Client Name - Error Message : " + firstNameAndLastNameErrorMessage);
				
			}
			
		}
		return this;
	}
	public CreateClientPage enterLastName(String LastName) {
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(LastName);
		
		String clientName = driver.findElement(By.xpath("//input[@id='firstname']")).getText();
		char[] y = clientName.toCharArray();
		int size = clientName.length();
		
		int i=0;
		while(i!=size)
		{
			if(y[i]>='0' && y[i] <= '9')
			{	
				String firstNameAndLastNameErrorMessage = driver.findElement(By.xpath("//span//small[@class='error required ng-binding']")).getText();
				System.out.println("Invalid data given for Client Name - Error Message : " + firstNameAndLastNameErrorMessage);
				
			}
			
		}
		return this;
	}
	public CreateClientPage enterMobileNumber(String MobileNumber) {
		driver.findElement(By.xpath("//input[@id='mobileNo']")).sendKeys(MobileNumber);
		return this;
	}
	public CreateClientPage enterEmailAddress(String EmailAddress) {
		driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys(EmailAddress);
		return this;
	}
	public CreateClientPage selectDateOfBirth(String day,String month) throws InterruptedException{
		
		driver.findElement(By.id("dateofbirth")).click();
		while(true)
		{
			String text = driver.findElement(By.xpath("(//button[@class='btn-black btn-block'])[1]/strong")).getText();
			if(text.equalsIgnoreCase(month))
			{
				break;
			}
			else
			{
				
				driver.findElement(By.xpath("(//button[@class='btn-black pull-left'])[1]")).click();		
			}
		}
		driver.findElement(By.xpath("//tr//td/button/span[contains(text(),"+day+")]")).click();	
		
				
		Thread.sleep(1000);	
		return this;
	}
	
	public HeadOfficePage clickSubmitButton() {
		driver.findElement(By.xpath("//button[@id='save']")).click();
		return new HeadOfficePage(driver);
	}
	
}
