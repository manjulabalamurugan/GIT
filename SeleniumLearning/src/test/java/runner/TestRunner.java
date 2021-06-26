package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


//AbstractTestNGCucumberTests - it is a method we use to run the cucumber testcases without @test cause it has call the functions inbuild inside
//@CucumberOptions - used to connect the all the cases
//(monochrome=true) - To remove Junk data from the o/p screen
// dry run= dummy run
@CucumberOptions(features= {"src/test/java/features/login.feature",
							"src/test/java/features/CreateLead.feature"},
					glue="steps" ,
					monochrome=true,
					publish=true,
					tags="@functional")
					
					//dryRun=true,
					//snippets=SnippetType.CAMELCASE)
public class TestRunner extends AbstractTestNGCucumberTests {

	
}
