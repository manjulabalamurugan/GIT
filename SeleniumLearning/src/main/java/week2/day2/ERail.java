package week2.day2;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERail {

	


	public static void main(String[] args) {
		
		//setup chromedriver using webdriver manager software
			WebDriverManager.chromedriver().setup();
		
		//launch chrome browser(classname->chromedriver)
			ChromeDriver driver=new ChromeDriver();
		
		//load the URL->get (method)
			driver.get("http://erail.in/");
		
		//you cannot resue already opened browser for the next run or the test
		
		//Maximize chrome browser
			driver.manage().window().maximize();
			
			
			//
			
			//enter from city and do TAB
			driver.findElement(By.id("txtStationFrom")).clear();
			Object keys;
			driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.TAB,Keys.TAB);
			
			//enter to city and do TAB
			driver.findElement(By.id("txtStationTo")).sendKeys("BANGALORE",Keys.TAB);
		
			//check sort on date
			driver.findElement(By.id("buttonFromTo")).click();
			
			
			//find the count of the trains
				java.util.List<WebElement> sizeof = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[1]"));
				int size = sizeof.size();
				
				System.out.println(size);
			//List-Dynamic Array
			//Array-Fixed Size
			
			//Find all the train Numbers
			
			
			java.util.List<WebElement> allTrainNumbers = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[1]"));
		
			//traverse through
			for (WebElement eachNumber : allTrainNumbers) {
				System.out.println(eachNumber.getText());
				
			}
			java.util.List<WebElement> allTrainName= driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]"));
			for (WebElement eachName : allTrainName) {
				System.out.println(eachName.getText());
				
			}
			
			
			
	}

}
