package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.ReadExcel;
public class ProjectSpecificMethods  {

	public  ChromeDriver driver;
	 public String excelFileName;
	 public static  ExtentHtmlReporter reporter;
	 public static  ExtentReports extent;
	 public   ExtentTest test,node;
	 public String testName, testDescription,testCategory,testAuthor;
	 
	 @BeforeSuite
	 public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	 @BeforeClass
	 public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	 public int takeSnap()  throws IOException{
		int ranNum = (int)(Math.random()*99999);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img"+ranNum+".png");
		FileUtils.copyFile(source, target);	
		
		return ranNum;
	}
	 public void reportStep(String msg,String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("fail")) {
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			throw new RuntimeException();
		}
	}
	 @DataProvider(name="fetchData")
		public  String[][] sendData() throws IOException
		{
					/*String[][] data = new String[1][3];
					data[0][0]="Test Leaf";
					data[0][1]="Hari";
					data[0][2]="R";*/
					
					return ReadExcel.Excel(excelFileName);
		}
	 
	@BeforeMethod
	public void preCondition() throws InterruptedException{
		node = test.createNode(testName);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@AfterMethod
	public void postCondition() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();

	}

	@AfterSuite
	 public void stopReport() {
		extent.flush();
	}
	
}
