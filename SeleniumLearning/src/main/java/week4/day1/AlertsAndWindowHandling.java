package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndWindowHandling {
/*
	1. Load https://www.irctc.co.in/
		2. Click on OK button in the dialog  // Alert
		3. Click on FLIGHTS link             // New window
		4. Go to the Flights tab
		5. Print the customer care email id
		6. Close the First tab(Train ticket booking) alone
*/
	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			// implicitwait
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			// load url
			driver.get("https://www.irctc.co.in/");
			driver.manage().window().maximize();
			//Click on OK button in the dialog  // Alert
			//driver.switchTo().alert().accept();
			driver.findElementByXPath("//button[contains(text(),'OK')]").click();
			
			//Click on FLIGHTS link  // New window
			driver.findElementByXPath("//a[contains(text(),' FLIGHTS ')]").click();
			//Go to the Flights tab
			Set<String> firstwindow=driver.getWindowHandles();
			List<String> listwindow=new ArrayList<String>(firstwindow);
			driver.switchTo().window(listwindow.get(1));
			//Print the customer care email id
			String email = driver.findElement(By.xpath("(//nav/div/a/following::a[text()=' flights@irctc.co.in'])[1]")).getText();
			System.out.println(email);
			//Close the First tab(Train ticket booking) alone
			driver.switchTo().window(listwindow.get(0));
			driver.close();
			
	}

}
