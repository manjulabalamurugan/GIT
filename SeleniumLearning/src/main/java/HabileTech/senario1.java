package HabileTech;

import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class senario1 {

	/*
	 * 1. Login in-to - https://salesdemo.habiletechnologies.com/
(qatest@habile.in/Qatest123$)
2. Go Clients menu, Select “Client”
3. &quot;Create Client&quot; as a Person.
● Ignore &quot;Staff&quot;
● Fill in basic fields like dob, display name, first name, last name,
gender, client type, client classification.
● Add address details.
● No family members details are required.
● Once create button is clicked, it directs to client details page
● (e.g., https://salesdemo.habiletechnologies.com/#/viewclient/10294 -
10294 is the client id) and click &quot;Activate&quot; to activate the client by
providing an activation date.
● You can also verify the created client by opening the &quot;Clients&quot; menu -&gt;
search by first name/client id in &quot;Find by name/mobile/client&quot; search
box or &quot;display name&quot; in &quot;Filter display by name&quot; search box.
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		// load url
		driver.get("https://salesdemo.habiletechnologies.com/");
		driver.manage().window().maximize();
		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='uid'][1]")).sendKeys("qatest@habile.in");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Qatest123$");
		driver.findElement(By.xpath("(//button[@id='login-button'])[1]")).click();
		Thread.sleep(3000);
		/*Actions action = new Actions(driver);
		WebElement Clients = driver.findElement(By.linkText("Clients"));
		action.moveToElement(Clients).perform();
		*/
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement moveClients = driver.findElement(By.xpath("//a[@id='client-dropdown']"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",moveClients);
		driver.findElement(By.linkText("Clients")).click();
		
		WebElement moveClients=driver.findElement(By.id("client-dropdown"));
		Select sort=new Select(moveClients);
		sort.selectByVisibleText("Clients");
		
		*/
		Actions action = new Actions(driver);
		WebElement Clients = driver.findElement(By.id("client-dropdown"));
		action.moveToElement(Clients).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li")).click();
		
//click create client button		
		driver.findElement(By.xpath("//a[@id='client_createbutton']")).click();
		
		WebElement findElement = driver.findElement(By.xpath("//input[@id='firstname']"));
		findElement.sendKeys("5manju");
		
		String clientName = findElement.getText();
		
		boolean errMsgFirstNamedisplayed = driver.findElement(By.xpath("//span//small[@class='error required ng-binding']")).isDisplayed();
		if(errMsgFirstNamedisplayed)
		{
			String text = driver.findElement(By.xpath("//span//small[@class='error required ng-binding']")).getText();
			System.out.println("Error Message : "+ text);
		}
		
		/*char[] y = clientName.toCharArray();
		int size = clientName.length();
		
		int i=0;
		while(i!=size)
		{
			if(y[i]>='0' && y[i] <= '9')
			{	
				String firstNameAndLastNameErrorMessage = driver.findElement(By.xpath("//span//small[@class='error required ng-binding']")).getText();
				System.out.println("Invalid data given for Client Name - Error Message : " + firstNameAndLastNameErrorMessage);
				
			}
			
		}*/
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("2alu");
		
		driver.findElement(By.xpath("//input[@id='mobileNo']")).sendKeys("a717001734");
		String clientNumber = driver.findElement(By.xpath("//input[@id='mobileNo']")).getText();
		/*
		char[] z = clientNumber.toCharArray();
		int size1 = clientNumber.length();
		for (int j = 0; j < z.length; j++) {
			if(!Character.isDigit(clientNumber.charAt(j)))
			{
				String text = driver.findElement(By.xpath("//small[@class='error required']")).getText();
				System.out.println("Invalid Contact Number - Error Message : " + text);
			}
			
		}
		Thread.sleep(3000);
*/
		driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys("5ms5447@gmail.com");
		boolean eRRMsgEmaildisplayed = driver.findElement(By.xpath("//span/small[contains(text(),' Enter Valid EMail Address ')]")).isDisplayed();
		if(eRRMsgEmaildisplayed)
		{
			String text = driver.findElement(By.xpath("//span/small[contains(text(),' Enter Valid EMail Address ')]")).getText();
			System.out.println("Error Message : "+ text);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String officeDropdown = "Transcapital 001";
		Actions action2 = new Actions(driver);
		WebElement office = driver.findElement(By.id("officeId_chosen"));
		action2.moveToElement(office).click().sendKeys(officeDropdown,Keys.ENTER).perform();
		

		String clientTypeDropdown = "Merchant";
		Actions action3 = new Actions(driver);
		WebElement clientType = driver.findElement(By.id("clienttypeId_chosen"));
		action3.moveToElement(clientType).click().sendKeys(clientTypeDropdown,Keys.ENTER).perform();
		Thread.sleep(1000);
		
		String genderDropdown = "Female";
		Actions action4 = new Actions(driver);
		WebElement gender = driver.findElement(By.id("genderId_chosen"));
		action4.moveToElement(gender).click().sendKeys(genderDropdown,Keys.ENTER).perform();
		Thread.sleep(1000);
		
		String clientClassificationDropdown = "Single";
		Actions action5 = new Actions(driver);
		WebElement clientClassification = driver.findElement(By.id("clientClassificationId_chosen"));
		action5.moveToElement(clientClassification).click().sendKeys(clientClassificationDropdown,Keys.ENTER).perform();
		Thread.sleep(1000);

		
		
		String month = "April 1998";
		String day = "07";
		driver.findElement(By.id("dateofbirth")).click();
		while(true)
		{
			String text = driver.findElement(By.xpath("(//button[@class='btn-black btn-block'])[1]/strong")).getText();
			if(text.equalsIgnoreCase(month))
			{
				break;
			}
			else
			{
				
				driver.findElement(By.xpath("(//button[@class='btn-black pull-left'])[1]")).click();		
			}
		}
		driver.findElement(By.xpath("//tr//td/button/span[contains(text(),"+day+")]")).click();	
		
				
		Thread.sleep(1000);	
//click submit button
		driver.findElement(By.xpath("//button[@id='save']")).click();
		driver.findElement(By.linkText("Activate")).click();
		
//activation Date		
		
				
		
		driver.findElement(By.xpath("(//input[@id='activationDate'])[2]")).click();
		
		WebElement today = driver.findElement(By.xpath("(//strong//a[@class='ng-binding'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",today);
		Thread.sleep(2000);	
		
		WebElement clickSubmitButton = driver.findElement(By.xpath("//button[@id='save']"));
		JavascriptExecutor click = (JavascriptExecutor) driver;
		click.executeScript("arguments[0].click();",clickSubmitButton);
		Thread.sleep(2000);	
		
		
		String clientText = driver.findElement(By.xpath("//small[@class='ng-binding']")).getText();
		String clientID = clientText.replaceAll("\\D","");
		System.out.println("Generated ClientID : " +clientID);
		
		Actions actionClient = new Actions(driver);
		WebElement Clients1 = driver.findElement(By.id("client-dropdown"));
		actionClient.moveToElement(Clients1).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li")).click();

		
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(clientID,Keys.ENTER);
		String VerifyClientID = driver.findElement(By.xpath("//tr[@class='pointer-main ng-scope']//td[contains(text(),"+clientID+")]")).getText();
		System.out.println("Found ClientID :  " + VerifyClientID);
		
		if(clientID.equalsIgnoreCase(VerifyClientID))
		{
			System.out.println("Client ID matched & client info created successfully");
		}
}
		
	}
//click Submit Button	
		