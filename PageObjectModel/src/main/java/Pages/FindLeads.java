package Pages;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLeads extends ProjectSpecificMethods {
	
	
	static String leadID;
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	//parameterized constructor is used here to call the driver to all the pages
public FindLeads(ChromeDriver driver)
{
	this.driver = driver;
}
	
	public FindLeads clickPhoneButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		Thread.sleep(3000);
		return this;
	}
	
	public FindLeads enterPhoneNumber(String phoneNumber) throws InterruptedException
	{

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		
		Thread.sleep(2000);
		return this;
	}
	
	public FindLeads clickFindLeadsButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		

		return this;
	}
	public ViewLeadPage clickLeadID() throws InterruptedException
	{ leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(2000);
		String titleofcurrentpage=driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		if(titleofcurrentpage.equalsIgnoreCase("view lead"))
			{
			System.out.println("It is confirmed successfully we are in view lead of first lead in find leads page");
			}
		else
			{
			System.out.println("We are not in View lead page");
			}
		return new ViewLeadPage(driver);
	}
	//driver will be passed to all the constructor
	
	public FindLeads enterLeadID()throws InterruptedException 
	{	
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		Thread.sleep(3000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		Thread.sleep(2000);
		return this;
	}
	public FindLeads enterFirstname(String fname) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);

		return this;
	}
	public FindLeads clickFindLeadsButtonOnMergeLead() throws InterruptedException
	{
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	return this;
	}
	public MergeLead clickLeadIDMergeLead() throws InterruptedException
	{
	String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles.get(0));
	Thread.sleep(2000);
	return new MergeLead();
	}
	public FindLeads enterLastname(String lname) throws InterruptedException
	{
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(lname);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));
	return this;
	}
}