package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class leafGroundWebTable {

	//public static class LeafGroundWebTable {

		public static void main(String[] args) {

			/*
			 * URL - http://www.leafground.com/pages/table.html
			 * 
			 * 1) Set the property for chromedriver and initialize the driver
			 *
			 * 2) launch the url
			 * 
			 * 3) Get the table and store it as a webelement
			 * 
			 * 4) Find the number of rows based on its tag name and store it in a list
			 * 
			 * 5) Find the number of cols based on its tag name and store it in a list
			 * 
			 * 6) Print the size of the rows
			 * 
			 * 7) Print the size of the cols
			 * 
			 * 8) Get the progress value of 'Learn to interact with Elements' and store it in a variable
			 * 
			 * 9) Print the text of the variable
			 * 
			 * 10) Find the vital task for the least completed progress and check the box
			 * 
			 * 
			 */		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/table.html");
			driver.manage().window().maximize();
			
			//Find the number of rows based on its tag name and store it in a list		
			List<WebElement> tablerow=driver.findElements(By.tagName("tr"));
			System.out.println("Size of Rows : "+tablerow.size());
		
			
		//Find the number of cols based on its tag name and store it in a list
		List<WebElement> tablecolumn=driver.findElements(By.tagName("th"));
		System.out.println("Size of Column: " + tablecolumn.size());
		
		//Get the progress value of 'Learn to interact with Elements' and store it in a variable

		WebElement element =   driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[3]/td[1]"));
       String progress = element.getText();
		 System.out.println("Third row of table : "+progress);
		 
		 
		 WebElement element1 =   driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[3]/td[2]"));
		String progress1 = element1.getText();
		System.out.println("Third row of table's Progress is : "+progress1);
			  
		 
		
		//Clicking checkbox (need to work on the condition )
		//click the checkbox
		//driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[4]/td[3]/input")).click();
		
		
		//td[contains(text(),'interact with Elements')]//following-sibling::td[1]
		WebElement Learn = driver.findElement(By.xpath("//td[contains(text(),'interact with Elements')]//following-sibling::td[1]"));
		System.out.println(Learn.getText());
			
		}}
