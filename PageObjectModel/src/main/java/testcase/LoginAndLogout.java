package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class LoginAndLogout extends ProjectSpecificMethods {
	@BeforeTest
	public void setFileName()
	{	//Sending a value for a global variable named excelfilename
		excelFileName = "Login";
	}	
	
@Test(dataProvider="fetchData")
	public void loginlogout(String username,String password)
	{
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clicklogoutbutton();
	}


}
