package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class DeleteLeadTestcase extends ProjectSpecificMethods{

@BeforeTest
public void setFileName()
{	//Sending a value for a global variable named excelfilename
	excelFileName = "DeleteLead";
}


@Test(dataProvider = "fetchData" )
public void runDeleteLead(String username,String password,String phoneNumber) throws InterruptedException
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
.clickDeleteButton()
.clickFindLeadslink()
.enterLeadID()
.clickFindLeadsButton();
}

}

