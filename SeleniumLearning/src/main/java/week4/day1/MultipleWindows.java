package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
/*
	http://leafground.com/pages/Window.html
		Click on Open Multiple Windows
		Print number of total windows open
		Move to the second window and print its title
		Close all the windows
*/
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();

	// load url
	
		driver.get("http://leafground.com/pages/Window.html");
	// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//Click on Open Multiple Windows
		driver.findElementByXPath("//button[contains(text(),'Open Multiple Windows')]").click();
		
		//get all the windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("No of Windows : " + windowHandles.size());
	//Move to the second Window
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1)); //second window
	// print its title
		String title = driver.switchTo().window(windows.get(1)).getTitle();
		System.out.println("Title of the second Window is : " + title);
		
		driver.switchTo().window(windows.get(0));
		driver.quit();


	}

}
