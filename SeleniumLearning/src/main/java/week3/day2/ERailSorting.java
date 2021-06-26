package week3.day2;

import java.util.Collections;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.Scanner;
public class ERailSorting {


	public static void main(String[] args) throws InterruptedException {
		
		
//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
//		Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		clear and type in the source station 		
		driver.findElementByXPath("//input[@id='txtStationFrom']").clear();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='txtStationFrom']").sendKeys("Chennai",Keys.TAB);
		
//		clear and type in the destination station
		driver.findElementByXPath("//input[@id='txtStationTo']").clear();
		driver.findElementByXPath("//input[@id='txtStationTo']").sendKeys("New Delhi",Keys.TAB);
		
//		Uncheck the check box - sort on date		
		Boolean date = driver.findElementByXPath("//input[@id='chkSelectDateOnly']").isSelected();
		if(date)
		{
			driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
		}
		else
		{
			driver.findElementByXPath("//input[@id='buttonFromTo']").click();
		}
		
//		Find all the train names using xpath and store it in a list
		
		int totalRows = driver.findElementsByXPath("//div/table[@class='DataTable TrainList TrainListHeader']//tr").size();
		System.out.println("Total No of Trains : " + totalRows);
		
		List<WebElement> totalTrainNames = driver.findElementsByXPath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr/td[2]/following::table[@class='DataTable TrainList TrainListHeader']//tr/td[2]");
					
//		Use Java Collections sort to sort it and then print it	
		
		ArrayList<String> sortedList = new ArrayList<String>();   
		sortedList.add("MAS NDLS EXP");
		sortedList.add("MAS NZM SPL");
		sortedList.add("MAS NZM DURONTO");
		sortedList.add("MDU NZM SPL");
		sortedList.add("CAPE NZM EXP");
		sortedList.add("MAS NDLS EXP");
		sortedList.add("MAS NDLS EXPRESS");
		Collections.sort(sortedList);
		
		for(String s:sortedList){
			System.out.println(s);
		}
		
		
	}
}

