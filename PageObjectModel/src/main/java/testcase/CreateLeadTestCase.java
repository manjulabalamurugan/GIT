package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.CreateLead;
import Pages.LoginPage;

public class CreateLeadTestCase extends ProjectSpecificMethods {
	@BeforeTest
	public void setFileName()
	{	//Sending a value for a global variable named excelfilename
		excelFileName = "CreateLead";
	}


@Test(dataProvider = "fetchData" )
	public void runCreateLead(String username,String password,String companyName,String fName,String lName) throws InterruptedException
	{
	//LoginPage obj = new LoginPage();
	new LoginPage(driver)
	.enterUsername(username)
	.enterPassword(password)
	.clickLoginButton()
	.clickCRMSALink()
	.clickLeadsLink()
	.clickCreateLeadsLink()
	.entercompanyName(companyName)
	.enterfirstName(fName)
	.enterlastName(lName)
	.clickCreateLeadButton()
	.verifyFirstName();
	}

}

