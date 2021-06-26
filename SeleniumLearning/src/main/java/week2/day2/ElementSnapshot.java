package week2.day2;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ElementSnapshot {


			public static void main(String[] args) throws IOException {
				//setup chromedriver using webdriver manager software
				WebDriverManager.chromedriver().setup();
			
			//launch chrome browser(classname->chromedriver)
				ChromeDriver driver=new ChromeDriver();
			
			//load the URL->get (method)
				driver.get("http://leaftaps.com/opentaps");
				
				
				//Getting the screenshot of a particular element
				WebElement findElement = driver.findElement(By.id("username"));
				File screenshotAs = findElement.getScreenshotAs(OutputType.FILE);
				 org.apache.commons.io.FileUtils.copyFile(screenshotAs,new File("./snaps/snaps1.jpg"));
			
				 //getting snapshot from one website to another website
				 driver.get("https://google.co.in");
				  File screenshotAs1 = driver.getScreenshotAs(OutputType.FILE);
				  org.apache.commons.io.FileUtils.copyFile(screenshotAs1,new File("./snaps/snaps2.jpg"));
			}

		}
