package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DailyQuestion {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//QUESTION: SELECT LAST BUT ONE OPTION FROM THE LIST(DROPDOWN)
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		
		WebElement dropdown = driver.findElementByXPath("//select[@id='cmbQuota']");
		Select lastButOne = new Select(dropdown);
		int all=lastButOne.getOptions().size();
		lastButOne.selectByIndex(all -2);
		//option[@value='DP']
		System.out.println("Size of the dropdown is " + all  );
	}

}
