package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	


	public static void main(String[] args) {
		
		//setup chromedriver using webdriver manager software
			WebDriverManager.chromedriver().setup();
		
		//launch chrome browser(classname->chromedriver)
			ChromeDriver driver=new ChromeDriver();
		
		//load the URL->get (method)
			driver.get("http://leaftaps.com/opentaps");
		
		//you cannot resue already opened browser for the next run or the test
		
		//Maximize chrome browser
			driver.manage().window().maximize();
			
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			String title = driver.getTitle();
			System.out.println(title);
			driver.findElement(By.linkText("CRM/SFA")).click();
			//driver.get("http://leaftaps.com/crmsfa/control/main?externalLoginKey=EL483246454846");
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCL");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Manjula");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Balu");
			
			//select source dropdown with one of the visisble text
			WebElement source=driver.findElement(By.id("createLeadForm_dataSourceId"));
			Select dd1=new Select(source);
			dd1.selectByVisibleText("Employee");
			
			
			//select marketing campagin with one of the value
			WebElement marketing=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
			Select dd2=new Select(marketing);
			dd2.selectByValue("CATRQ_CAMPAIGNS");
			
			driver.findElement(By.className("smallSubmit")).click();
			String title1 = driver.getTitle();
			System.out.println(title1);
	}

}
