package week2.day1;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		System.out.println(driver.findElementByName("username").getAttribute("value"));
		System.out.println(driver.findElementByName("username").isEnabled());
		System.out.println(driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input").isEnabled());
		
		System.out.println(driver.findElementByName("username").getCssValue("color"));
		driver.get("http://leafground.com/pages/Link.html");
		 System.out.println(driver.findElementByLinkText("Verify am I broken?").getAttribute("href"));
		 System.out.println(driver.findElementByLinkText("How many links are available in this page?").getAttribute("href"));
		 driver.get("http://leafground.com/pages/Button.html");
		 System.out.println(driver.findElementById("home").getText());
		 System.out.println(driver.findElementById("home").getLocation());
		 System.out.println(driver.findElementById("home").getSize());
		 System.out.println(driver.findElementById("home").getTagName());
		 System.out.println(driver.findElementById("home").isDisplayed());
		 System.out.println(driver.findElementById("home").isEnabled());
		 System.out.println(driver.findElementByXPath("//*[@id=\"home\"]").isEnabled());
		 driver.get("http://leafground.com/pages/checkbox.html");
		 System.out.println(driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/input").isSelected());
		 
		

		 driver.close();
	
	}

}
		
		
		
		

	


