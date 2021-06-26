package week4.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
/*
	1. Launch URL: "https://www.nykaa.com/"
		2. Enter text as Perfumes in Search Bar and press Enter
		3. Get The Names Of all the Perfumes Displayed 
		4. Get The Price of all the Perfumes Displayed
		5. Click on the Highest Price Perfume  
		6. Click on Add To Bag
		7. verify Message Product Added To the bag 
		8. Click on bag Icon
		9. Get the Grand Total Value
		10. Click on Proceed
		11. Click on Continue as Guest
		12. Fill all the Fields in Address 
		13. Click on Paynow
		14. Get the Error Message displayed in Red Color
		15. close the current browser
*/
	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			ChromeDriver driver=new ChromeDriver();
			// load url
			driver.get("https://www.nykaa.com/");
			driver.manage().window().maximize();
			// implicitwait
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//Enter text as Perfumes in Search Bar and press Enter
			driver.findElementById("SearchInputBox").sendKeys("Perfumes",Keys.ENTER);
//Get The Names Of all the Perfumes Displayed 
			
			List<WebElement> names = driver.findElementsByXPath("//div[@class='main-product-listing-page']//div[@class='m-content__product-list__title']/h2");
			System.out.println("Total Number of Perfumes : " + names.size());
			for (int i = 0; i < names.size(); i++) {
				String perfumeNames = names.get(i).getText();
				System.out.println(" The Name of the Perfume No " + i + " is " + perfumeNames);
			}
				
//Get The Price of all the Perfumes Displayed
		
			List<WebElement> price = driver.findElementsByXPath("//div[@class='price-info']//span[@class='post-card__content-price-offer']");
			
			
			for (int i = 0; i < price.size(); i++) {
				String Price = price.get(i).getText();
				String replacePrice = Price.replaceAll("\\D", "");
				System.out.println("The Price of the Perfume No " + i + " is " + replacePrice);
				
			}
			
//Click on the Highest Price Perfume  	
		
		List<WebElement> highPrice = driver.findElementsByXPath("//span[@class='post-card__content-price-offer']");
		int a=0;
		WebElement element = null;
		for (int i = 0; i < highPrice.size(); i++) {
			String priceToString = highPrice.get(i).getText();
			String replacePrice1 = priceToString.replaceAll("\\D", "");
			int parseInt = Integer.parseInt(replacePrice1);
			if(parseInt>a)
			{
				a=parseInt;
				int value1 = i+1;
				element= driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])["+ value1 +"]"));
				
			}
		}	
		System.out.println("Highest perfume price: " +a);
		element.click();
		
//Click on Add To Bag		
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windows = new ArrayList<String>(windowHandles);
			driver.switchTo().window(windows.get(1));
			
			
			driver.findElementByXPath("//button[text()='ADD TO BAG']").click();
//verify Message Product Added To the bag 
			boolean displayed = driver.findElementByXPath("//div[text()='Item added to cart']").isDisplayed();
			if(displayed)
			{
				System.out.println("Item successfully added to the bag");
			}
//Click on bag Icon
			
			driver.findElementByClassName("AddBagIcon").click();
			Thread.sleep(2000);
//Get the Grand Total Value
			
			String total = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
			System.out.println("Grand total value : " + total);
//Click on Proceed
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement proceed = driver.findElementByXPath("//i[@class='proceed-arrow']");
			js.executeScript("arguments[0].click()",proceed);
			
			Thread.sleep(2000);
//Click on Continue as Guest
			driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
			Thread.sleep(3000);
//Fill all the Fields in Address 
			driver.findElementByXPath("(//div[@class='inner-wrap']/input)[1]").sendKeys("Manjula");
			driver.findElementByXPath("(//div[@class='inner-wrap']/input)[2]").sendKeys("manju@gmail.com");
			driver.findElementByXPath("(//div[@class='inner-wrap']/input)[3]").sendKeys("9600032084");
			driver.findElementByXPath("(//div[@class='inner-wrap']/input)[4]").sendKeys("600019");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement address = driver.findElementByXPath("//textarea[@class='textarea-control prl10']");
			wait.until(ExpectedConditions.visibilityOf(address)).sendKeys("5656 566");
			Thread.sleep(1000);
			driver.findElementByXPath("//button[@type='submit']").click();
//Click on Paynow
			Thread.sleep(2000);
			driver.findElementByXPath("//div[@class='prl10 pb10']//button[@type='submit']").click();
			
//Get the Error Message displayed in Red Color	
			String text1 = driver.findElementByXPath("(//i[@class='error-icon'])[3]/preceding::span[text()='This field is required.']").getText();
			System.out.println("If card details not entered then it will show this error message: "+ text1);
			
			String text2 = driver.findElementByXPath("(//i[@class='error-icon'])[3]/preceding::span[3]").getText();
			System.out.println("If Expiry date is not entered then it will show this error message: "+ text2);
			
			String text3 = driver.findElementByXPath("(//i[@class='error-icon'])[3]/following::span").getText();
			System.out.println("If CVV is not entered then it will show this error message: "+ text3);
//close the current browser
			driver.quit();
	}
	
}
