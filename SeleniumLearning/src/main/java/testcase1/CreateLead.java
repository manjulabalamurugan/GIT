package testcase1;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

@Test(invocationCount = 5)
	public void runCreateLead() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.name("submitButton")).click();
		//driver.close();
		
		System.out.println("Priority 1");
}	

/*@DataProvider
public String[][] sendData(){
	String[][] data = new String[2][3];
	
	data[0][0]="TestLeaf";
	data[0][1]="Hari";
	data[0][2]="R";
	
	data[1][0]="TL";
	data[1][1]="Naveen";
	data[1][2]="Raj";
	return data;

}*/
}






