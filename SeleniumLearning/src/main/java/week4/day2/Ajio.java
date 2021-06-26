package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
/*
 * Assessment Test Case:
===================
1) Go to the URL https://www.ajio.com/shop/sale 
2) Enter Bags in the Search field and Select Women Handbags 
3) Click on five grid and Select SORT BY as "What's New"
4) Click Price on the side menu and Enter Price Range Min as 2000 and Max as 5000
5) Click on the first product 
6) Get the actual price, coupon code and discount price
7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
8) Click on Other Informations under Product Details and Print the Customer Care details
9) Click on ADD TO BAG and then GO TO BAG 
10) Check the Order Total before apply coupon 
11) Enter Coupon Code and Click Apply 
12) Print the warning message if the product is not eligible discount
	12(a) Verify the bill amount is matching with the discount price or not 
13) Click on Delete and Delete the item from Bag 
14) Close all the browsers

 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		// load url
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		// Enter Bags in the Search field and Select Women Handbags 
		
		driver.findElementByXPath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input").sendKeys("Bags",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElementByXPath("//label[@for='Women']").click();
		driver.findElementByXPath("//label[@for='Women - Handbags']").click();
		// Click on five grid 
		driver.findElementByClassName("five-grid").click();
		// Select SORT BY as "What's New"
		WebElement whatsNew=driver.findElement(By.xpath("//div[@class='filter-dropdown']/select"));
		Select sort=new Select(whatsNew);
		sort.selectByValue("newn");
		
		
		//Click Price on the side menu and Enter Price Range Min as 2000 and Max as 5000
		driver.findElementByXPath("//div[@class='facet-head ']").click();
		driver.findElementById("minPrice").sendKeys("2000");
		driver.findElementById("maxPrice").sendKeys("5000");
		
		driver.findElementByXPath("//input[@id='maxPrice']/following-sibling::button[1]").click();
		// Click on the first product 
		driver.findElementByXPath("//div[@class='name']").click();
		
		//move to next window
		Set<String> firstwindow=driver.getWindowHandles();
		List<String> listwindow=new ArrayList<String>(firstwindow);
		driver.switchTo().window(listwindow.get(1));
		
		//Get the actual price, coupon code and discount price
		String text = driver.findElementByXPath("//div[contains(text(),'Rs. 3,779')]").getText();
		String aprice = text.replaceAll("\\D","");
		System.out.println("Actual Price "+ aprice);
		
		String text1 = driver.findElementByXPath("//div[@class='promo-discounted-price']/span").getText();
		String dprice = text1.replaceAll("\\D","");
		System.out.println("Discount Price "+ dprice);
		
		String text2 = driver.findElementByXPath("//div[@class='promo-title']").getText();
		String[] words = text2.split("Use Code");
		String couponCode = (words[words.length-1]).replaceAll("[^a-zA-Z]", "");
		System.out.println(couponCode);
		
		
		//Check the availability of the product for pincode
		
		driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();
		
				
		driver.findElementByXPath("(//input[@class='edd-pincode-modal-text'])").sendKeys("560043");
		
	
		driver.findElementByXPath("//button[contains(text(),'CONFIRM PINCODE')]").click();
		
		//print the expected delivery date if it is available
	
		String text3 = driver.findElementByXPath("//ul/li/span[contains(text(),'16 Apr')]").getText();
		System.out.println("Expected Delivery Date"+ text3);
		//Click on Other Informations under Product Details and 
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		//Print the Customer Care details
		String text4 = driver.findElementByXPath("(//div[@class='mandatory-list'])[6]").getText();
		System.out.println(text4);		
	//Click on ADD TO BAG and then GO TO BAG
	
	driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
	//div[@class='popup-blk cart-blk']//div
	driver.findElementByXPath("//div[text()='PROCEED TO BAG']").click();
	
	
	//Enter Coupon Code and Click Apply 
	 //Print the warning message if the product is not eligible discount
	
	WebElement new1 = driver.findElementByXPath("//input[@placeholder='Enter coupon code']");
	new1.sendKeys(couponCode);
	driver.findElementByXPath("//button[text()='Apply']").click();
	boolean couponValidate = driver.findElementByXPath("//span[text()='Your coupon has been redeemed successfully']").isDisplayed();
	if(couponValidate)
	 {
		System.out.println("voucher is valid");
	}
	else
	{
		System.out.println("invalid");
	}
	
	
	
	// Verify the bill amount is matching with the discount price or not 
	//bill amt
	String text6 = driver.findElementByXPath("//span[text()='Order Total']/following-sibling::span").getText();
	System.out.println(text6);
	//discount
	String text7 = driver.findElementByXPath("//p[@class='saving-text']//span").getText();
	System.out.println(text7);
	
	
	//Click on Delete and Delete the item from Bag
	
	driver.findElementByXPath("//div[text()='Delete']").click();
	driver.findElementByXPath("//div[text()='DELETE']").click();
	}

}
