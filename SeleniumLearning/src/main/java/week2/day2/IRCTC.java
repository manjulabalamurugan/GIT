package week2.day2;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC {

	//code is correct 
	static int i=0;
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		// load url
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");

		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		// Identify the element and store
		WebElement element=driver.findElementById("userRegistrationForm:nationalityId");

		// create an object using Select class for an webelement 
		Select dropdown=new Select(element);

		// get collection of webelement and store it in list
		
		java.util.List<WebElement> options = dropdown.getOptions();
		//iterations through each webElement based on condection
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


