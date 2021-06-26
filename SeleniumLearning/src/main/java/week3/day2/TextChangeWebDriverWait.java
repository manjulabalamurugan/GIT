package week3.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;

public class TextChangeWebDriverWait {
		//https://peter.sh/experiments/chromium-command-line-switches/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		//implicit wait - is applied globally- available for all web elements
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement disappear = driver.findElementById("//button[@id='btn']");
		
		wait.until(ExpectedConditions.invisibilityOf(disappear));
		//driver.findElementByLinkText("Click ME!").click();
		//System.out.println(disappear.isDisplayed());
		boolean disappear1 = disappear.isDisplayed();
		if(disappear1)
		{
			driver.findElementByLinkText("Click ME!").click();
			
		}
		
		
//output is wrong
		//here is the correct code
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
		driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
		String s= driver.switchTo().alert().getText();
		if(s.equals("Click ME!"))
		{
			System.out.println("Text displayed in the alert: " + s);
		}
		
	driver.quit();
		
	}

}
