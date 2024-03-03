package Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features= {".\\Feature\\featurefile.feature"},
		glue= "StepDefination",
		plugin = {"pretty","html:CucumberReport/cucumber_report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false
				)
public class TestRun {

}
