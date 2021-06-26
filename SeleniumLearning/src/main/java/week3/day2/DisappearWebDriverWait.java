package week3.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisappearWebDriverWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		// load url
		driver.get("http://www.leafground.com/pages/disapper.html");

		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement disappear = driver.findElementByXPath("//button[@id='btn']");
		wait.until(ExpectedConditions.invisibilityOf(disappear));
		boolean disappear1 = disappear.isDisplayed();
		if(!disappear1)
		{
			System.out.println(driver.findElementByXPath("//div[@id='show']/p").getText());
			
		}
		else
		{
			System.out.println("Nothing to display");
			
		}
		
	}

}
