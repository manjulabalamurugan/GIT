import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException,InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();ation\\chrome.exe");

						//WebDriver driver = new ChromeDriver();
		  driver.get("http://demo.guru99.com/selenium/upload/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  //open upload window
		     
		    // findElement.click();
		 
		    Thread.sleep(4000); 
		     JavascriptExecutor js = (JavascriptExecutor) driver;
		     

		   driver.findElement(By.id("uploadfile_0")).click();
				   //"//input[@type='search']"))
					//Actions action = new Actions(driver);
					//action.moveToElement(findElement).click().build();
					
			//	action
		     //put path to your image in a clipboard
		     
		   Thread.sleep(2000); 
		     //imitate mouse events like ENTER, CTRL+C, CTRL+V
		     Robot robot = new Robot();
		     
		     StringSelection ss = new StringSelection("C:\\snaps\\Questions\\Array.doc");
		     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		     
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
