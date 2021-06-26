package week3.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusAAssigment {

	public static void main(String[] args)  throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		//Type C in the FROM text box
		//3.Choose the second option and ENTER 
		driver.findElement(By.id("src")).sendKeys("C");
		Thread.sleep(5000);
		driver.findElement(By.id("src")).sendKeys(Keys.DOWN, Keys.ENTER);
		
		//4.Type in the Destination text box
		//5.Choose the first option and TAB
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("B");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys(Keys.DOWN, Keys.ENTER);
		//6.Choose the first date in April
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/td[3]")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']//td[4]")).click();
		
		//7.Choose the first option and TAB
		
		
		//8.Click Search Buses
		driver.findElement(By.xpath("//button[@class='fl button']")).click();
		
		//9.Print the number of search results
		
		String text=driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']/span")).getText();
		System.out.println("No of buses : " + text);
		//10.Choose only Sleeper Bus
		driver.findElement(By.xpath("//div[@class='close']/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='filter-block']//ul[3]/li[2]/label[1]")).click();		
		//11.Print the number of search results

		String text1=driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']/span")).getText();
		System.out.println("No of Sleeper : " + text1);
		//12.Choose also AC buses
		driver.findElement(By.xpath("//div[@id='filter-block']//ul[3]/li[3]/label[1]")).click();		
		
		//13.Print the number of search results
		String text2=driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']/span")).getText();
		System.out.println("No of Sleeper with AC : " + text2);
		
		//14.Find the Bus name that is costliest in the result shown
		List<WebElement> allFares = driver.findElements(By.className("fare"));
		System.out.println(allFares.size());
		for (int i = 0; i < allFares.size(); i++) {
			System.out.println(allFares.get(i).getText());
			
		}
				
	}

}
