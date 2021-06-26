package week8.day1;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {


	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	    	WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			ChromeDriver driver=new ChromeDriver();
			// load url
		
			driver.manage().window().maximize();
			
			String underConsTitle = "Under Construction: Mercury Tours";					
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);					
			 String baseUrl = "http://demo.guru99.com/test/newtours/";
			driver.get(baseUrl);					
        
        java.util.List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        String[] linkTexts = new String[linkElements.size()];							
			int	i = 0;					

			//extract the link texts of each link element		
			for (WebElement e : linkElements) {							
			linkTexts[i] = e.getText();			
			i++;			
        }		

			//test each link		
			for (String t : linkTexts) {							
			driver.findElement(By.linkText(t)).click();					
			if (driver.getTitle().equals(underConsTitle)) {							
                System.out.println("\"" + t + "\""								
                        + " is under construction.");			
            } else {			
                System.out.println("\"" + t + "\""								
                        + " is working.");			
            }		
			driver.navigate().back();			
        }		
			driver.quit();			
    }		
}
