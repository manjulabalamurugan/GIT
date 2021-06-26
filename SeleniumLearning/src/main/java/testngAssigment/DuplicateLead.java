package testngAssigment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass{
	
	@BeforeTest
	public void setFileName()
	{
		excelFileName = "DuplicateLead";
	}	
	
		
@Test(dataProvider = "sendData")
	public void runDuplicateLead(String Contact,String Title) throws InterruptedException {
		
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(Contact);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys(Title);
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(3000);
		//driver.close();
}
}






