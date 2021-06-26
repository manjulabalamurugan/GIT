package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import base.ProjectSpecificMethods;

public class S1_TC_RF_001 extends ProjectSpecificMethods{

	@BeforeTest
	public void setFileName()
	{	//Sending a value for a global variable named excelfilename
		excelFileName = "S1_TC_RF_001";
	}


@Test(dataProvider = "fetchData" )
	public void runTest1(String username,String password,String clientsDropDown,String FirstName,String MobileNumber,String officeDropdown) throws InterruptedException,IOException
	{
	//LoginPage obj = new LoginPage();
	new LoginPage(driver)
	.enterUserName(username)
	.enterPassword(password)
	.clickLoginInButton()
	.moveToClientsDropdown(clientsDropDown)
	.clickCreateClient()
	.enterFirstName(FirstName)
	.enterMobileNumber(MobileNumber)
	.officeDropdown(officeDropdown)
	.clickSubmitButton()
	.clickActivateButton();
	
	}

	
}
