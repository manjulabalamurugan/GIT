package week8.day1;
import java.io.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	
	public static void main(String[] args)throws IOException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		reporter.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest test = extent.createTest("LoginAndLogout", "Login with positive data");
		test.assignCategory("Functional");
		test.assignAuthor("Hari");
		test.pass("enter username",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/leaftaps.png").build());
		test.pass("enter password", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/psw.png").build());
		test.pass("Click Login Button", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/login.png").build());
		
		extent.flush();
	}

}
