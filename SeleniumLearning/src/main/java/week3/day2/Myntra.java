package week3.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
public class Myntra {

	/*
	 * 1) Open https://www.myntra.com/
2) Mouse over on WOMEN 
3) Click Jackets & Coats
4) Find the total count of item 
5) Validate the sum of categories count matches
6) Check Coats
7) Click + More option under BRAND	
8) Type MANGO and click checkbox
9) Close the pop-up x
10) Confirm all the Coats are of brand MANGO
11) Sort by Better Discount
12) Find the price of first displayed item
13) Mouse over on size of the first item
14) Click on WishList Now
15) Close Browser
	 */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
//		Launch the URL - https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
// 		Mouse over on WOMEN 		
		Actions actions = new Actions(driver);
		WebElement target = driver.findElementByXPath("//div[@class='desktop-navLink']//a[@data-group='women']");
		actions.moveToElement(target).perform();
//		Click Jackets & Coats
		driver.findElementByLinkText("Jackets & Coats").click();
//		 Find the total count of item 	
		int k=0;
		String element = driver.findElementByXPath("//span[@class='title-count']").getText();
		
		String count1 = element.replaceAll("\\D",""); //remove all except digit after removing we need to convert the string to int
		
		int toInteger=Integer.parseInt(count1);  
		System.out.println("Total count of Jackets & Coats " + toInteger);
//		Validate the sum of categories count matches		
		
				//String sumOfCategories = driver.findElementByXPath("//span[@class='categories-num']").getText();
		String sumOfCategories1 = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String sumOfCategories2 = driver.findElementByXPath("//span[@class='categories-num']").getText();
		String replace1 = sumOfCategories1.replaceAll("[()]", "");
		String replace2 = sumOfCategories2.replaceAll("[()]", "");
		int i=Integer.parseInt(replace1);  
		int j=Integer.parseInt(replace2);  
		if(i>0 && j>0)
		{
			k=i+j;
			System.out.println("Sum of Jackets & Coats " + k);
		}
		
	if(k==toInteger)
	{
		System.out.println("Both values are same so VERIFIED!");
	}
			
	//		Check Coats
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		
	//		Click + More option under BRAND	
		driver.findElementByXPath("//div[@class='brand-more']").click();
		
	//	 Type MANGO and click checkbox	
			//input[@placeholder='Search brand']
			
		WebElement element1 =driver.findElementByXPath("//input[@placeholder='Search brand']");
		element1.sendKeys("Mango");
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();
		
	//	Close the pop-up x	
		
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
	// 	Confirm all the Coats are of brand MANGO
		
		WebElement element2 = driver.findElementByXPath("//div[contains(text(),'Coats')]");
		Boolean b = element2.isDisplayed();
		System.out.println("Are these Coats? " + b);
		WebElement element3 = driver.findElementByXPath("//div[contains(text(),'MANGO')]");
		Boolean c = element3.isDisplayed();
		System.out.println("Are these coats from Mango? " + c);
		

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		
		
	//	Sort by Better Discount
		
		Actions actions1 = new Actions(driver);
		WebElement target1 = driver.findElementByXPath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']");
		actions1.moveToElement(target1).perform();
		driver.findElementByXPath("//label[contains(text(),'Better Discount')]").click();
		
	//	Find the price of first displayed item
		
		String element5 = driver.findElementByXPath("(//div[@class='product-price']//span[@class='product-discountedPrice'])[1]").getText();
		System.out.println("Price of first displayed item " + element5);
	// 	Mouse over on size of the first item
				
		Actions actions2 = new Actions(driver);
		WebElement target2 = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]");
		actions2.moveToElement(target2).perform();
				
	//	Click on WishList Now
		driver.findElementByXPath("(//span[@class='myntraweb-sprite product-notWishlistedIcon sprites-notWishlisted'])[1]").click();
	//	Close Browser
		driver.close();
		
	}

}
