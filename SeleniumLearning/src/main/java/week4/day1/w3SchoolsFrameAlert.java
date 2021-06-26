package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w3SchoolsFrameAlert {
	/*
	 Hint
	Switch to the frame
	Then click Try It with xpath
	Switch to the alert
	Then perform accept / dismiss
	Get the text using id 
	Verify the text based on the action
	*/
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		// load url
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		// implicitwait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	
		//Click Try It Button
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[contains(text(),'Try it')]").click();
		//Click OK/Cancel in the alert
		driver.switchTo().alert().accept();
		
		//Confirm the action is performed correctly by verifying the text !!
		String text = driver.findElementByXPath("//p[contains(text(),'You pressed OK!')]").getText();
		System.out.println(text);
		
		//Verify the text based on the action
		boolean displayed = driver.findElementByXPath("//p[contains(text(),'You pressed OK!')]").isDisplayed();
		System.out.println(displayed);
		//close the Frame
		driver.switchTo().defaultContent();
		
	}

}
