package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import Base.ProjectSpecificMethods;

public class MergeLead extends ProjectSpecificMethods {

	
	
	public FindLeads clickIcon1(){
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		return new FindLeads(driver);
	}
	
	public FindLeads clickIcon2(){
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		return new FindLeads(driver);
	}
	
	public ViewLeadPage clickMergeLeadButton() throws InterruptedException{
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		return new ViewLeadPage(driver);
	}

}
