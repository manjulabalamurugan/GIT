package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC2 {

	static int i=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		// load url
		driver.get("https://www.irctc.co.in/nget/train-search");

		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		// Identify the element and store
		WebElement findElement = driver.findElement(By.xpath("//span[@class='ng-tns-c58-8 ui-autocomplete ui-widget']"));
		
		// create an object using Select class for an webelement 
		Select dropdown=new Select(findElement);
		
		// get collection of webelement and store it in list
	List<WebElement> options = dropdown.getOptions();
	for (WebElement eachoption : options) {
		if (eachoption.getText().startsWith("E")) {
			i++;
			if (i==2) {
				System.out.println(eachoption.getText());
				eachoption.click();
				break;
			}
		}
	}

	//close browser
	driver.close();
		
		
	
	}

}
