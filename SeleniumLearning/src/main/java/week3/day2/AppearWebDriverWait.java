package week3.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppearWebDriverWait {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		// load url
		driver.get("http://www.leafground.com/pages/appear.html");

		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement appear = driver.findElementByXPath("//button[@id='btn']/b[1]");
		wait.until(ExpectedConditions.visibilityOf(appear));
		boolean element = appear.isDisplayed();
		if(element)
		{
			System.out.println("Element is appeared : " + driver.findElementByXPath("//button[@id='btn']/b").getText());
		}
		else
		{
			System.out.println("Element is not appeared");
		}
		
	}

}
