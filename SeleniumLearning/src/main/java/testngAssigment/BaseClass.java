package testngAssigment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass {
  public  ChromeDriver driver; //global variable
  public String excelFileName;
   

 @Parameters({"url","username","password"})
@BeforeMethod
	public void preCondition(String url,String username,String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

 }

@AfterMethod
public void postCondition() {
	driver.close();
}


@DataProvider
public String[][] sendData() throws IOException
{
			/*String[][] data = new String[1][3];
			data[0][0]="Test Leaf";
			data[0][1]="Hari";
			data[0][2]="R";*/
			
			return ReadExcel.Excel(excelFileName);
}



}
