package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Work {


	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
		 List<WebElement> tableRows = driver.findElements(By.xpath("//table//tr"));
		 for(int i=0;i<=tableRows;i++)
		 {
			 tableRows.findElement(By.xpath("//td[2]"));
			 
		 }

	}

}
