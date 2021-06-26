package week2.day2;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Assignment1Dropdown
{
		// TODO Auto-generated constructor stub
		public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//Select Training program using index
				WebElement trainingProgram=driver.findElement(By.id("dropdown1"));
				Select a1=new Select(trainingProgram);
				a1.selectByIndex(1);
		
		//Select Training program using text
				WebElement trainingProgramText=driver.findElement(By.name("dropdown2"));
				Select a2=new Select(trainingProgramText);
				a2.selectByVisibleText("Selenium");
				
		//Select Training program using text
				 WebElement trainingProgramValue = driver.findElement(By.id("dropdown3"));
				 Select a3 = new Select(trainingProgramValue);
				 a3.selectByValue("1");
				 
		//Select Get the number of dropdown options 
				 java.util.List<WebElement> dropdownOption = driver.findElements(By.tagName("option"));
				 System.out.println(dropdownOption.size());
				 
				 for (WebElement eachName : dropdownOption) {
						System.out.println(eachName.getText());
						
					}
				 
				 //Select the dropdown value using value
				 
				 WebElement noOfDropdown = driver.findElement(By.className("dropdown"));
				 Select a4 = new Select(noOfDropdown);
				 a4.selectByValue("2");
				
				 
		//Select using sendKeys  
				
				 
		
		driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys("Selenium");
				
				//Select using program
		 driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select/option[3]")).click();
		 
		
		 
		
	}

	}
