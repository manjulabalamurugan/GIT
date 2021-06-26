package week4.day2;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.*;
public class PepperFry {
/*
	1) Go to https://www.pepperfry.com/
		2) Mouseover on Furniture and click Office Chairs under Chairs
		3) click Executive Chairs
		4) Change the minimum Height to 50 in under Dimensions
		5) Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist
		6) Mouseover on Bedroom and Click Study tables
		7) Select Spacewood as Brand
		8) Select Price as 7000 to 8000
		9) Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish
		" to Wishlist
		10) Verify the number of items in the Wishlist
		11) Navigate to Wishlist
		12) Move Table only to Cart from Wishlist
		13) Click Proceed to Pay Securely
		14) Enter Pincode as 600028 in Delivery & Assembly Details and click Go
		14) Click Place Order
		15) Capture a screenshot by Clicking on Order Summary
		16) Close the browser
		*/ 
	public static void main(String[] args) throws IOException,InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		// implicitwait
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		// load url
		driver.get("https://www.pepperfry.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='reg_login_box']//a[@class='popup-close'])[1]")));
		driver.findElementByXPath("(//div[@id='reg_login_box']//a[@class='popup-close'])[1]").click();
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElementById("webklipper-publisher-widget-container-notification-close-div").click();
		driver.switchTo().defaultContent();
		
	// Mouseover on Furniture and click Office Chairs under Chairs
			Actions actions5 = new Actions(driver);
			WebElement target5 = driver.findElementByXPath("(//a[@class='level-top'])[1]");
			actions5.moveToElement(target5).perform();
			driver.findElementByLinkText("Office Chairs").click();
		//click Executive Chairs
			
			driver.findElementByXPath("//h5[text()='Executive Chairs']").click();
	
		//Change the minimum Height to 50 in under Dimensions
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").clear();
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys("50",Keys.ENTER);
		
		Thread.sleep(2000);
		//Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist
		
		
		driver.findElementByXPath("//div/a[@data-productid='1888861']").click();
		
		//Mouseover on Bedroom and Click Study tables
		Actions action = new Actions(driver);
		WebElement bedroom = driver.findElementByLinkText("Bedroom");
		action.moveToElement(bedroom).perform();
		driver.findElementByXPath("//div[@id='meta-bedroom']/div[1]/div[4]/div[2]/div[3]/a[1]").click();
		
				
		// Select Spacewood as Brand
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement spacewood = driver.findElementByXPath("//label[@for='brandsnameSpacewood']");
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",spacewood);
		//Select Price as 7000 to 8000
		
		WebElement price = driver.findElementByXPath("//label[@for='price7000-8000']");
		js.executeScript("arguments[0].click();",price);
		
		Thread.sleep(2000);
		//Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish " to Wishlist
		
		WebElement source1 =driver.findElementByXPath("(//a[@class='clip-heart-icn pf-right'])[4]");
		js.executeScript("arguments[0].click();",source1);
		
		//Verify the number of items in the Wishlist

		boolean noOfItems = driver.findElementByXPath("//span[text()='2']").isDisplayed();
		String text = driver.findElementByXPath("//span[text()='2']").getText();
		if(noOfItems)
		{
			System.out.println("No of items in the wishlist : " + text);
		}
		else
		{
			System.out.println("No items in the wishlist");
		}
		
		// Navigate to Wishlist
		
		driver.findElementByXPath("//a[@class='wishlist_bar']").click();

		
		//Move Table only to Cart from Wishlist
		
		WebElement cart = driver.findElementByXPath("(//div[@class='mini_cart capitalize active']//div[@class='item_details_holder']//a[@data-tooltip='Add to Cart'])[1]");
		js.executeScript("arguments[0].click();",cart);
		
		
		//Click Proceed to Pay Securely
		
		WebElement paySecurely = driver.findElementByXPath("//a[text()='Proceed to pay securely ']");
		js.executeScript("arguments[0].click();",paySecurely);
		
		//Enter Pincode as 600028 in Delivery & Assembly Details and click Go
		
		driver.findElementById("pin_code").sendKeys("600028");
		driver.findElementById("pin_check").click();
		// Click Place Order
		WebElement placeOrder = driver.findElementByXPath("//a[@class='btn_green_big']");
		js.executeScript("arguments[0].click();",placeOrder);
		//Capture a screenshot by Clicking on Order Summary
		
		driver.findElementByXPath("//span[text()='(1 Items)']").click();
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		  File destination = new File("ordersummary.jpg");
		FileUtils.copyFile(screenshotAs, destination);
		
		
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElementById("webklipper-publisher-widget-container-notification-close-div").click();
		driver.switchTo().defaultContent();
		//Close the browser
		driver.quit();
		
		
	}

}
