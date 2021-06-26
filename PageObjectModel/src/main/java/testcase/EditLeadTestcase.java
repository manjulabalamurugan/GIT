package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.EditLead;
import Pages.LoginPage;

public class EditLeadTestcase extends ProjectSpecificMethods {
	@BeforeTest
	public void setFileName()
	{	//Sending a value for a global variable named excelfilename
		excelFileName = "EditLead";
	}
	
@Test(dataProvider="fetchData")
public void runEditLead(String username,String password,String phoneNumber,String companyName) throws InterruptedException
{
	//LoginPage obj = new LoginPage();
	new LoginPage(driver)
	.enterUsername(username)
	.enterPassword(password)
	.clickLoginButton()
	.clickCRMSALink()
	.clickLeadsLink()
	.clickFindLeadslink()
	.clickPhoneButton()
	.enterPhoneNumber(phoneNumber)
	.clickFindLeadsButton()
	.clickLeadID()
	.clickEditButton()
	.enterCompanyName(companyName)
	.clickUpdateButton().verifyCompanyAfterEditing();

	}
	
}
