package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.ReadExcel;
public class ProjectSpecificMethods  {

	public  ChromeDriver driver;
	 public String excelFileName;
	 
	 @DataProvider(name="fetchData")
		public  String[][] sendData() throws IOException
		{
					/*String[][] data = new String[1][3];
					data[0][0]="val";
					data[0][1]="val";
					data[0][2]="val";*/
					
					return ReadExcel.Excel(excelFileName);
		}
	 
	@BeforeMethod
	public void preCondition() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://salesdemo.habiletechnologies.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterMethod
	public void postCondition() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();

	}

	
}
