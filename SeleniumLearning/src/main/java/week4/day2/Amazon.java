package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon  {

	/*
	 * 1. Launch URL: https://www.amazon.in/
2. Type "one plus 7 pro mobiles" in Search Box and Enter
3. Print the price of the first resulting mobile
4. Click on the Mobile (First resulting) image
5. Switch to the new window
6. Print the number of customer ratings
7. Click 'Add to Cart'
8. Confirm "Added to Cart" text message appeared
9. Click on Proceed to checkout
10. Confirm the title is "Amazon Sign In"
11. Click Continue (without entering mobile number/email)
12. Verify the error message: Enter your email or mobile phone number
13. Close both browsers
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		// load url
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		// implicitwait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//Type "one plus 7 pro mobiles" in Search Box and Enter
		driver.findElementById("twotabsearchtextbox").sendKeys("one plus 7 pro mobiles",Keys.ENTER);
//Print the price of the first resulting mobile
		
		String price = driver.findElementByXPath("//span[@class='a-price-whole']").getText();
		System.out.println("price of the first resulting mobile : " + price);
		
//Click on the Mobile (First resulting) image		
		
		driver.findElementByXPath("//img[@class='s-image']").click();
		
//Switch to the new window		
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
//Print the number of customer ratings		
		
		String rating = driver.findElementByXPath("//span[@id='acrCustomerReviewText']").getText();
		System.out.println("number of customer ratings : " + rating);
		
//Click 'Add to Cart'
		
		driver.findElementById("add-to-cart-button").click();
		
//Confirm "Added to Cart" text message appeared
		
		boolean displayed = driver.findElementByXPath("(//h4[text()='Added to Cart'])[2]").isDisplayed();
		if(displayed)
		{
			System.out.println("item is added to the cart successfully");
		}
		
		
//Click on Proceed to checkout
				
		driver.findElementByXPath("//span[@id='attach-sidesheet-checkout-button']/span[1]/input[1]").click();
		
		
//Confirm the title is "Amazon Sign In"		
		
		if(driver.getTitle().contains("Amazon Sign In"))
		{
			System.out.println("The Title is successfully verified");
		}
// Click Continue (without entering mobile number/email)
		
		driver.findElementByXPath("//input[@id='continue']").click();
		
//Verify the error message: Enter your email or mobile phone number		
		
		String errorMessage = driver.findElementByXPath("(//i[@class='a-icon a-icon-alert']/following-sibling::div)[2]").getText();
		if(errorMessage.contains("Enter your email or mobile phone number"))
		{
			System.out.println("Here is the Error Message : " + errorMessage);
		}
		
//Close both browsers
		//driver.quit();
	}

}
