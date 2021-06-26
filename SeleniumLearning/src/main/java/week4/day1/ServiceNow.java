package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
//load url
		driver.get("https://dev68594.service-now.com/");
		driver.manage().window().maximize();
//implicitwait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//Enter username as “admin”
		driver.findElementByXPath("(//div[@class='login']//div//label/following-sibling::input)[1]").sendKeys("admin");
//Enter password as “India@123”
		driver.findElementByXPath("(//div[@class='login']//div//label/following-sibling::input)[2]").sendKeys("India@123");
//Click Login
		driver.findElementByXPath("//button[@id='sysverb_login']").click();
//Search “incident “ Filter Navigator.
		driver.findElementByXPath("//input[@id='filter']").sendKeys("incident",Keys.ENTER);
//Click “All”
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement all = driver.findElementByXPath("(//div[@class='sn-widget-list-title ng-binding'])[12]");
		js.executeScript("arguments[0].click()",all);
//Click New button
		driver.findElementByXPath("//div[@class='navbar-header']//button[@class='selected_action action_context btn btn-primary']").click();
//Select a value for Caller and Enter value for short_description
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("(//span[@class='input-group-btn'])[1]").click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>();
		driver.switchTo().window(windowList.get(1));
		
		driver.findElementByXPath("//a[contains(text(),'Zackary Mockus')]").click();
//Read the incident number and save it a variable
		
//Click on Submit button
//Search the same incident number in the next search screen as below
// Verify the incident is created successful
		

	}

}
