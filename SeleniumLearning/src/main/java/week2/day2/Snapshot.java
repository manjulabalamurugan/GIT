package week2.day2;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapshot {



	public static void main(String[] args) throws IOException {
		//setup chromedriver using webdriver manager software
		WebDriverManager.chromedriver().setup();
	
	//launch chrome browser(classname->chromedriver)
		ChromeDriver driver=new ChromeDriver();
	
	//load the URL->get (method)
		driver.get("https://google.co.in");
		//you cannot resue already opened browser for the next run or the test
	
  File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
  File destination = new File("./snaps/snaps.jpg");
  org.apache.commons.io.FileUtils.copyFile(screenshotAs,destination); 
  
  
  // if you want to write the above code in a simple way
  File screenshotAs1 = driver.getScreenshotAs(OutputType.FILE);
  org.apache.commons.io.FileUtils.copyFile(screenshotAs1,new File("./snaps/snaps1.jpg"));
	}

}
