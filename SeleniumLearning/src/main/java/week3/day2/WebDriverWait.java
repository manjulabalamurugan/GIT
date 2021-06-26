package week3.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWait {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		// load url
		driver.get("http://leafground.com/pages/disapper.html");

		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement disappear = driver.findElementById("btn");
		
		wait.until(ExpectedConditions.invisibilityOf(disappear));
		System.out.println(disappear.isDisplayed());

	}

}
