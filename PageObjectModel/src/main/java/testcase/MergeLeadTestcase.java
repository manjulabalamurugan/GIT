package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class MergeLeadTestcase extends ProjectSpecificMethods{

		 @BeforeTest
		 public void setFileName()
		 {	//Sending a value for a global variable named excelfilename
		 	excelFileName = "MergeLead";
		 }


		 @Test(dataProvider = "fetchData" )
		 public void runDeleteLead(String username,String password,String fname,String lname) throws InterruptedException
		 {
		 //LoginPage obj = new LoginPage();
		 new LoginPage(driver)
		 .enterUsername(username)
		 .enterPassword(password)
		 .clickLoginButton()
		 .clickCRMSALink()
		 .clickLeadsLink()
		 .clickMergeLeadLink()
		 .clickIcon1()
		 .enterFirstname(fname)
		 .clickFindLeadsButtonOnMergeLead()
		 .clickLeadIDMergeLead()
		 .clickIcon2()
		 .enterLastname(lname)
		 .clickFindLeadsButton()
		 .clickLeadIDMergeLead()
		 .clickMergeLeadButton().clickFindLeadslink().enterLeadID().clickFindLeadsButtonOnMergeLead();
		 
		 }

}
