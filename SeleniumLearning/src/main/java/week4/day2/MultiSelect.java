package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelect {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		// implicitwait
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		// load url
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
WebElement item1 = driver.findElementByXPath("(//select//option[contains(text(),'Selenium')])[6]");
WebElement item4 = driver.findElementByXPath("(//select//option[contains(text(),'Loadrunner')])[6]");

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item4).keyUp(Keys.CONTROL).perform();
		
	}

}
