package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import Pages.LoginPage;

public class LoginAndLogout extends base.ProjectSpecificMethods {
	@BeforeTest
	public void setFileName()
	{	//Sending a value for a global variable named excelfilename
		excelFileName = "Login";
		testName = "LoginWithValidData";
		testDescription = "Verify login with valid data";
		testCategory = "functional";
		testAuthor = "hari";
	}	
	
@Test(dataProvider="fetchData")
	public void loginlogout(String username,String password)throws IOException
	{
		new LoginPage(driver,node)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clicklogoutbutton();
	}


}
