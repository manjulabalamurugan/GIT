package week4.day1;
import java.io.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	/*
	 * 1. Launch https://www.snapdeal.com/
2. Go to Mens Fashion
3. Go to Sports Shoes
4. Get the count of the sports shoes
5. Click Training shoes
6. Sort by Low to High
7. Check if the items displayed are sorted correctly
7. select the brand Puma
8. Mouse Hover on puma Blue Training shoes
9. click QuickView button
10. Print the cost and the discount percentage
11. Take the snapshot of the shoes.
12. Close the current window
14. Close the main window

	 */

	public static void main(String[] args) throws InterruptedException,IOException{
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
//load url
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
//implicitwait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
//Go to Mens Fashion
		Thread.sleep(3000);
		WebElement men = driver.findElementByXPath("(//li[text()='More Categories']/following::span)[1]");
		Actions menFashion = new Actions(driver);
		menFashion.moveToElement(men).perform();;
//Go to Sports Shoes
		driver.findElementByXPath("//span[text()='Sports Shoes']").click();
//Get the count of the sports shoes
		String countOfShoes = driver.findElementByXPath("//div/h1/span").getText();
		String replaceAll = countOfShoes.replaceAll("\\D", "");
		System.out.println("Total No of Sports Shoes : " + replaceAll);
//Click Training shoes
		driver.findElementByXPath("//div[text()='Training Shoes']").click();
//Sort by Low to High
//Check if the items displayed are sorted correctly
	
		List<WebElement> sortinglist = driver.findElementsByXPath("//span[@class='lfloat product-price']");
		List<Integer> sorting = new ArrayList<Integer>();
		
	for (WebElement eachval : sortinglist) {
		String text = eachval.getText().replaceAll("\\D", "");
		int parseInt2 = Integer.parseInt(text);
		sorting.add(parseInt2);
	}
		Collections.sort(sorting);
		System.out.println("The sorted order of low to high : " +sorting);
		
		//Method 2
		/*
		 * List<WebElement> sorted = driver.findElements(By.xpath("//div[@class='product-desc-rating ']//div//span[2]"));
		System.out.println("Total training shoes present in the page: " + sorted.size());
		WebElement firstPrice = driver.findElement(By.xpath("(//div[@class='product-desc-rating ']//div//span[2])[1]"));
		String firstPriceText = firstPrice.getText();
		firstPriceText = firstPriceText.replaceAll("[^0-9]", "").replaceAll("\\s", "");
		int firstValue = Integer.parseInt(firstPriceText);

		for (int i = 0; i < sorted.size(); i++) {

			String text = sorted.get(i).getText();
			text = text.replaceAll("[^0-9]", "").replaceAll("\\s", "");
			int text1 = Integer.parseInt(text);
			if (text1 < firstValue) {
				System.out.println("The items not sorted Correctly: " + i);
			} else {
				System.out.println(text1 + "--->" + i);
			}
		 */
//select the brand Puma	
				driver.findElementByXPath("//input[@class='sd-input js-searchable-box']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//input[@class='sd-input js-searchable-box']").sendKeys("Puma",Keys.ENTER);
				driver.findElementByXPath("//label[@for='Brand-Puma']//a").click();
				driver.findElementByXPath("//div[@class='rfloat button-width']//div").click();		
		
//Mouse Hover on puma Blue Training shoes
//click QuickView button
				Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement pumashoes = driver.findElementByXPath("//p[@title='Puma Blue Training Shoes']");
		js.executeScript("arguments[0].click()",pumashoes);
		

		Set<String> firstwindow=driver.getWindowHandles();
		List<String> listwindow=new ArrayList<String>(firstwindow);
		driver.switchTo().window(listwindow.get(1));
//Print the cost and the discount percentage
		//span[@class='pdp-final-price']
		//span[@class='pdpDiscount ']
		String cost = driver.findElementByXPath("//span[@class='pdp-final-price']").getText();
		String discount = driver.findElementByXPath("//span[@class='pdpDiscount ']").getText();
		System.out.println("Price and the discount percentage for the PUMA shoe : " + cost + " " + discount);
//Take the snapshot of the shoes.
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		 File destination = new File("shoes.jpg");
		FileUtils.copyFile(screenshotAs, destination);

//Close the current window
		driver.close();
		driver.switchTo().window(listwindow.get(0));
//Close the main window
		driver.quit();

		
		/*
		//move control to last window opened by selenium
String windowHandle = driver.getWindowHandle();
driver.switchTo().window(windowHandle);

		Set<String> windows = driver.getWindowHandles();
		List<String> windowList =new ArrayList<String>(windows);
		for (int i = 0; i < windowList.size() ; i++) {
			System.out.println(" Window Title of the " + i + "Page is" + driver.switchTo().window(windowList.get(i)).getTitle());
		}
		
		String lastWindow = windowList.get(windowList.size()-1);
		driver.switchTo().window(lastWindow);
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
