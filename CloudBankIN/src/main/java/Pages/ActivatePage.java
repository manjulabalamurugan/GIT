package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class ActivatePage extends ProjectSpecificMethods {

	
	public ActivatePage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	public ActivatePage selectActivationDate() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@id='activationDate'])[2]")).click();
		
		WebElement today = driver.findElement(By.xpath("(//strong//a[@class='ng-binding'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",today);
		Thread.sleep(2000);	
		return this;
	}
	public HeadOfficePage clickSubmitButton() throws InterruptedException {
		WebElement clickSubmitButton = driver.findElement(By.xpath("//button[@id='save']"));
		JavascriptExecutor click = (JavascriptExecutor) driver;
		click.executeScript("arguments[0].click();",clickSubmitButton);
		Thread.sleep(2000);	
		return new HeadOfficePage(driver);
}
}
