package week8.day1;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile  {

	public static void main(String[] args)throws AWTException,InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		// load url
		driver.get("http://demo.guru99.com/selenium/upload/");
		driver.manage().window().maximize();
/*
		ChromeDriver() driver = new ChromeDriver();
		  driver.get("http://demo.guru99.com/selenium/upload/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  //open upload window
		     
		    // findElement.click();
*/		 
		     
		     JavascriptExecutor js = (JavascriptExecutor) driver;

		     WebElement findElement = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
				Thread.sleep(3000);
				js.executeScript("arguments[0].click();",findElement);
				
				
		     //put path to your image in a clipboard
		     StringSelection ss = new StringSelection("C:\\snaps\\Questions\\Array");
		     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		     //imitate mouse events like ENTER, CTRL+C, CTRL+V
		     Robot robot = new Robot();
		     robot.delay(250);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		     robot.keyPress(KeyEvent.VK_CONTROL);
		     
		     robot.keyPress(KeyEvent.VK_V);
		     robot.keyRelease(KeyEvent.VK_V);
		     robot.keyRelease(KeyEvent.VK_CONTROL);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.delay(90);
		     robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
