package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaMahaCode {

	public static void main(String[] args) throws InterruptedException {
		
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				WebDriver driver = new ChromeDriver(chromeOptions); 
				//ChromeDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				
				//Launch URL
				driver.get("https://www.nykaa.com/");
				
				//Enter text as Perfumes in Search Bar and press Enter
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Perfumes",Keys.ENTER);
				
				//Get The Names Of all the Perfumes Displayed
				System.out.println("In the current Page- " + driver.findElement(By.xpath("//div[@class='page-title-search-result']")).getText());
				List<WebElement> perfumeName= driver.findElements(By.xpath("//div[@class='m-content__product-list__title']/..//h2/span"));
				System.out.println("Total Number of Perfume Name: " +perfumeName.size() );
				for(int i=0;i<perfumeName.size();i++)
				{
					String PN= perfumeName.get(i).getText();
					System.out.println("Perfume Name: " + i + " : " + PN);
				}
				System.out.println("-----------------------------------------------------------------------------");
				
				// Get The Price of all the Perfumes Displayed
				List<WebElement> perfumeprice= driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));
				System.out.println("Total Number of Perfume Price available: " +perfumeprice.size() );
				for(int i=0;i<perfumeprice.size();i++)
				{
					String PP= perfumeprice.get(i).getText();
					PP=PP.replaceAll("[^0-9]","");
					System.out.println("Perfume Price of " + i + "th perfume: " +PP);
				
				}
				System.out.println("-----------------------------------------------------------------------------");
				
				//5. Click on the Highest Price Perfume
				
				List<WebElement> perfumeprice1= driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));
				int a=0;
				WebElement ele = null;
				for(int i=0;i<perfumeprice.size();i++)
				{
					String PP= perfumeprice.get(i).getText();
					PP=PP.replaceAll("[^0-9]","");
					int maxValue= Integer.parseInt(PP);
					if(maxValue>a)
					{
						a=maxValue;
						int val = i+1;
						ele= driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])["+ val +"]"));
						
					}
					
				}
				System.out.println("Highest perfume price: " +a);
				ele.click();
				
				//6. Click on Add To Bag
				Set allWindow= driver.getWindowHandles();
				List<String> l = new ArrayList<String>(allWindow);
				driver.switchTo().window(l.get(1));
				WebElement addToBag= driver.findElement(By.xpath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]"));
				addToBag.click();
				Thread.sleep(3000);
				
				//verify Message Product Added To the bag 
				System.out.println("Following message displayed after adding to bag: " + driver.findElement(By.xpath("(//div[@class='add-to-bag-message']/div)[1]")).getText());
				
				// Click on bag Icon
				driver.findElement(By.xpath("//div[@class='cursor-hand arrowup-tooltip']")).click();
				
				//Get the Grand Total Value
			    WebElement grandTotal= driver.findElement(By.xpath("//div[@class='first-col']//div[@class='value']"));
			    Thread.sleep(3000);
			    String text=grandTotal.getText();
			    text=text.replaceAll("[^0-9]","");
				System.out.println("Grand Total: "+ text);
				
				// Click on Proceed
				driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
				
				//Click on Continue as Guest
				driver.findElement(By.xpath("//button[@class='btn full big']")).click();
				
				// Fill all the Fields in Address 
				driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mahalakshmi");
				driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mmahalak12@gmail.com");
				driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9789974843");
				driver.findElement(By.xpath("//input[@name='pinCode']")).sendKeys("600069");
				driver.findElement(By.xpath("//textarea[contains(@class,'textarea-control pr')]")).sendKeys("Kundrathur");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(3000);
				
				//Click on Paynow
				try
				{
				WebElement pay= driver.findElement(By.xpath("//button[@type='submit']"));
				Thread.sleep(3000);
				pay.click();
				}
				
				catch(Exception e) {
					driver.findElement(By.xpath("//button[@type='submit']"));
				}
				
				//Get the Error Message displayed in Red Color
				System.out.println("If the card number not entered the following message is displayed: "+ driver.findElement(By.xpath("(//span[@class='field-error'])[1]")).getText());
				System.out.println("If the card number expiry year not entered the following message is displayed: "+ driver.findElement(By.xpath("(//span[@class='field-error'])[2]")).getText());
				System.out.println("If the card number CVV not entered the following message is displayed: "+ driver.findElement(By.xpath("(//span[@class='field-error'])[2]")).getText());
				Thread.sleep(3000);
				
				//close the current browser
				driver.close();
				
				
				
				

				
				

			}
}
		
/*

		Output:
		------
		In the current Page- Showing 20 of 2782  results for 'Perfumes'
		Total Number of Perfume Name: 20
		Perfume Name: 0: Nykaa Love Struck Perfume
		Perfume Name: 1: BVLGARI Rose Goldea Blossom Delight Eau De Parfum
		Perfume Name: 2: Ramsons You are lovely Eau De Perfume
		Perfume Name: 3: Moi By Nykaa Mini Pocket Perfume
		Perfume Name: 4: Engage W2 Perfume Spray For Women
		Perfume Name: 5: Skinn By Titan Celeste Perfume For Women EDP
		Perfume Name: 6: Moi By Nykaa Eau de Perfume
		Perfume Name: 7: Skinn by Titan Celeste Perfume For Women EDP
		Perfume Name: 8: Nykaa Cosmetics Masaba By Nykaa Mini Pocket Perfume
		Perfume Name: 9: The Body Shop British Rose Eau De Toilette
		Perfume Name: 10: Masaba By Nykaa Perfume
		Perfume Name: 11: Carolina Herrera Good Girl Eau De Parfum
		Perfume Name: 12: Estee Lauder Modern Muse Eau De Parfum
		Perfume Name: 13: Paco Rabanne 1 Million Eau De Toilette
		Perfume Name: 14: Skinn By Titan Raw Perfume For Men EDP
		Perfume Name: 15: Davidoff Cool Water Eau De Toilette For Men
		Perfume Name: 16: Davidoff Cool Water Eau De Toilette for Men
		Perfume Name: 17: Yves Saint Laurent Libre Eau De Parfum
		Perfume Name: 18: Skinn by Titan Celeste Perfume For Women EDP
		Perfume Name: 19: Moi By Nykaa Mini Pocket Perfume - Raison D'Etre
		-----------------------------------------------------------------------------
		Total Number of Perfume Price available: 20
		Perfume Price of 0th perfume: 699
		Perfume Price of 1th perfume: 7050
		Perfume Price of 2th perfume: 102
		Perfume Price of 3th perfume: 212
		Perfume Price of 4th perfume: 185
		Perfume Price of 5th perfume: 1595
		Perfume Price of 6th perfume: 1260
		Perfume Price of 7th perfume: 595
		Perfume Price of 8th perfume: 254
		Perfume Price of 9th perfume: 1295
		Perfume Price of 10th perfume: 1260
		Perfume Price of 11th perfume: 5675
		Perfume Price of 12th perfume: 5500
		Perfume Price of 13th perfume: 4400
		Perfume Price of 14th perfume: 1595
		Perfume Price of 15th perfume: 4600
		Perfume Price of 16th perfume: 4600
		Perfume Price of 17th perfume: 5600
		Perfume Price of 18th perfume: 1595
		Perfume Price of 19th perfume: 249
		-----------------------------------------------------------------------------
		Highest perfume price: 7050
		Following message displayed after adding to bag: Item added to cart
		Grand Total: 7050
		If the card number not entered the following message is displayed: THIS FIELD IS REQUIRED.
		If the card number expiry year not entered the following message is displayed: REQUIRED
		If the card number CVV not entered the following message is displayed: REQUIRED
		? 2021 GitHub, Inc.
		Terms
		Privacy
		Security
		Status
		Docs
		Contact GitHub
		Pricing
		API
		Training
		Blog
		About
		Loading complete
*/

