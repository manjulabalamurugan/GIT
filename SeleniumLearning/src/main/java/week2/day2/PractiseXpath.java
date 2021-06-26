package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseXpath {

		// TODO Auto-generated method stub
		public static void main(String[] args) {

			/*
			**No need to write Selenium script - Just find these elements in the DOM using only XPaths
			
			Try all the xpaths that you've learnt (basic, text-based, axes..)
			1. Launch the URL
			
		
			2. Enter the username based on its label
			
			3. Enter the password based on its label
			
			4. Click Login
			
			5. Click on CRMSFA link
			
			6. Click on Leads link
			
			7. Click on Merge Leads link
			
			8. Click the first img icon
			
			9. Select the first resulting lead
			
			10. Click the second img icon
			
			11. Select the second resulting lead
			
			12. Click on Merge Lead (submit) button
			
			13. Get the company name text based on its label
			
			*/
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			
			//Launch URL "http://leaftaps.com/opentaps/control/login"
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			
			//Enter the username based on its label
			driver.findElementByXPath("//label[text()='Username']/following-sibling::input").sendKeys("DemoSalesManager");
			//Enter the password based on its label
			driver.findElementByXPath("//label[text()='Password']/following-sibling::input").sendKeys("crmsfa");
			//Click Login
			driver.findElementByClassName("decorativeSubmit").click();
			//Click on CRMSFA link
			driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
			//Click on Leads link
			driver.findElementByXPath("//a[contains(text(),'Leads')]").click();
			//Click on Merge Leads link
			driver.findElementByXPath("//a[contains(text(),'Merge Leads')]").click();
			//Click the first img icon
			driver.findElementByXPath("//a[@id='ext-gen605']/img").click();
			//Select the first resulting lead
			
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@id='ext-gen313']").click();
			//Click the second img icon
			driver.findElementByXPath("//a[@id='ext-gen603']/img").click();
			//Select the second resulting lead
			
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@id='ext-gen332']").click();
			//Click on Merge Lead (submit) button
			driver.findElementByXPath("//a[contains(text(),'buttonDangerous')]").click();
			//Get the company name text based on its label
			WebElement findElementByXPath = driver.findElementByXPath("//td[@id='ext-gen615']//span");
			String text = findElementByXPath.getText();
			System.out.println(text);
	}
		
}

//CORRECT ANSWER -CHECK IT LATER
//driver.get("http://leaftaps.com/crmsfa/control/viewLead?partyId=10054");

driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
driver.findElement(By.xpath("//div[@id='label']/a]")).click();
driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();

driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
driver.findElement(By.xpath("//@a[text()='Merge']"));
String compName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
System.out.println(compName);