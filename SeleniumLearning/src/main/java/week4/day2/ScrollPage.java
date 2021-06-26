package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollPage {

	public ScrollPage() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
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
		
//Click on the Highest Price Perfume  
		//SCROLLING BY USING PIXEL
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)","");
		
		//SCROLLING PAGE UNTIL WE FIND ELEMENT
		WebElement source = driver.findElementByXPath("//span[text()='Carolina Herrera Good Girl Eau De Parfum']");
		js.executeScript("arguments[0].scrollIntoView();",source);
		
		//SCROLL PAGE TILL BOTTOM
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		

	}

}
