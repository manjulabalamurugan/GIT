package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import Pages.CreateLead;
import Pages.LoginPage;

public class CreateLeadTestCase extends base.ProjectSpecificMethods {
	@BeforeTest
	public void setFileName()
	{	//Sending a value for a global variable named excelfilename
		excelFileName = "CreateLead";
		testName = "Create Lead";
		testDescription = "Create lead with mandatory data";
		testCategory = "functional";
		testAuthor = "hari";
	}


@Test(dataProvider = "fetchData" )
	public void runCreateLead(String username,String password,String companyName,String fName,String lName) throws InterruptedException,IOException
	{
	//LoginPage obj = new LoginPage();
	new LoginPage(driver,node)
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

