package week3.day2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
//		Set the system property and Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		Click the 'sort on date' checkbox
		Boolean date = driver.findElementByXPath("//input[@id='chkSelectDateOnly']").isSelected();
		if(date)
		{
			driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
		}
		else
		{
			driver.findElementByXPath("//input[@id='buttonFromTo']").click();
		}
//		clear and type in the from station text field
		driver.findElementByXPath("//input[@id='txtStationFrom']").clear();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='txtStationFrom']").sendKeys("Chennai",Keys.TAB);
		
//		clear and type in the to station text field
		driver.findElementByXPath("//input[@id='txtStationTo']").clear();
		driver.findElementByXPath("//input[@id='txtStationTo']").sendKeys("New Delhi",Keys.TAB);
//		Add a java sleep for 2 seconds
		Thread.sleep(2000);
//		Store all the train names in a list
		List<WebElement> totalTrainNames = driver.findElementsByXPath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr/td[2]/following::table[@class='DataTable TrainList TrainListHeader']//tr/td[2]");
//		Get the size of it
		System.out.println("Total No of Trains : " + totalTrainNames.size());
//		Add the list into a new Set
		Set<String> list = new HashSet<String>();
		list.add("MAS NDLS EXP");
		list.add("MAS NZM SPL");
		list.add("MAS NZM DURONTO");
		list.add("MDU NZM SPL");
		list.add("CAPE NZM EXP");
		list.add("MAS NDLS EXP");
		list.add("MAS NDLS EXPRESS");
		for(String s:list){
			System.out.println(s);
		}
		
//		And print the size of it
		System.out.println("Count of Unique Train Names are : " + list.size());
	}

}
