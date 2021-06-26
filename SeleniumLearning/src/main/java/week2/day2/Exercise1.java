package week2.day2;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise1 {

	

	public static void main(String[] args) {

		//setup chromedriver using webdriver manager software
			WebDriverManager.chromedriver().setup();
		
		//launch chrome browser(classname->chromedriver)
			ChromeDriver driver=new ChromeDriver();
		
		//load the URL->get (method)
			driver.get("http://leafground.com/pages/table.html");
		
		//you cannot resue already opened browser for the next run or the test
		
		//Maximize chrome browser
			driver.manage().window().maximize();
			
			//print the number of rows in the table
			java.util.List<WebElement> tableRows1 = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
			//List-Dynamic Array
			//Array-Fixed Size
			
			System.out.println(tableRows1.size());
			
			//print the mentor names 
			java.util.List<WebElement> mentorName = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[5]"));
			System.out.println(mentorName.size());
			
			for (WebElement eachMentor : mentorName) {
				System.out.println(eachMentor.getText());
				
			}
	}

}
