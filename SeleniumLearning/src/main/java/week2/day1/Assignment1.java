package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	
		public static void main(String[] args) {

	
		//setup chromedriver using webdriver manager software
		WebDriverManager.chromedriver().setup();
	
	//launch chrome browser(classname->chromedriver)
		ChromeDriver driver=new ChromeDriver();
	
	//load the URL->get (method)
		driver.get("http://leaftaps.com/opentaps");
	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("ManjuQ1");
		driver.findElement(By.name("parentPartyId")).sendKeys("democlass1");
		driver.findElement(By.id("groupNameLocal")).sendKeys("ManjuS4");
		driver.findElement(By.id("officeSiteName")).sendKeys("access");
		driver.findElement(By.id("annualRevenue")).sendKeys("1000");
		driver.findElement(By.id("numberEmployees")).sendKeys("45");
		driver.findElement(By.id("tickerSymbol")).sendKeys("15");
		driver.findElement(By.name("description")).sendKeys("filling it for testing");
		driver.findElement(By.name("importantNote")).sendKeys("Selenium");
		driver.findElement(By.name("sicCode")).sendKeys("11");
		driver.findElement(By.name("primaryPhoneCountryCode")).sendKeys("1");
		driver.findElement(By.id("primaryPhoneAreaCode")).sendKeys("600019");
		driver.findElement(By.name("primaryPhoneExtension")).sendKeys("12");
		driver.findElement(By.name("primaryEmail")).sendKeys("mans@gmail.com");
		driver.findElement(By.id("primaryPhoneNumber")).sendKeys("1234567890");
		driver.findElement(By.name("primaryPhoneAskForName")).sendKeys("sasikala");
		driver.findElement(By.name("primaryWebUrl")).sendKeys("http://chrome.com");
		
		driver.findElement(By.name("generalToName")).sendKeys("balu");
		driver.findElement(By.name("generalAddress1")).sendKeys("87/A");
		driver.findElement(By.name("generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("generalPostalCode")).sendKeys("600019");
		driver.findElement(By.id("generalPostalCodeExt")).sendKeys("01");
		driver.findElement(By.id("generalAttnName")).sendKeys("Sassy");
		driver.findElement(By.id("generalAddress2")).sendKeys("thiruvottiyur");
		

		
		
		
		//select prefferedCurrency dropdown with one of the value
				WebElement prefferedCurrency=driver.findElement(By.id("currencyUomId"));
				Select dd1=new Select(prefferedCurrency);
				dd1.selectByValue("ALL");
		
		//select industry with visible text
				WebElement industryType=driver.findElement(By.name("industryEnumId"));
				Select dd2=new Select(industryType);
				dd2.selectByVisibleText("Finance");
		
		//select ownership with index
				WebElement ownership=driver.findElement(By.name("ownershipEnumId"));
				Select dd3=new Select(ownership);
				dd3.selectByIndex(5);
			
		
		//select source with visible text
				WebElement sourceD=driver.findElement(By.id("dataSourceId"));
				Select dd5=new Select(sourceD);
				dd5.selectByVisibleText("Partner");
				
		//select InitialTeam dropdown with one of the value
				WebElement InitialTeam=driver.findElement(By.name("initialTeamPartyId"));
				Select dd6=new Select(InitialTeam);
				dd6.selectByValue("DemoSalesTeam1");		
		
		//select Marketing Campaign with index
				WebElement marketing=driver.findElement(By.id("marketingCampaignId"));
				Select dd7=new Select(marketing);
				dd7.selectByIndex(2);
				
		//select COUNTRY with value
				WebElement country=driver.findElement(By.name("generalCountryGeoId"));
				Select dd8=new Select(country);
				dd8.selectByValue("IND");
				
		//select State/Province with value ( Not Working )
				//WebElement state1=driver.findElement(By.name("generalStateProvinceGeoId"));
				//Select dd9=new Select(state1);
				//dd9.selectByValue("IN-TN");
				
		driver.findElement(By.className("smallSubmit")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
	}

}
