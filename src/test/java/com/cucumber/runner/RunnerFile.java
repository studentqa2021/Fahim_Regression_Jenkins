package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		
		plugin = {//report
				"html:target/report/cucumber.html",
				"json:target/cucumber.json"
				
		},
		
		features = {"src/test/resources/ScenarioOutlineLogin.feature"}, //path
		glue = {"com.cucumber.stepdef"}, //stepdef package name
		monochrome = true
		
	)

public class RunnerFile extends AbstractTestNGCucumberTests {
	
	

}
