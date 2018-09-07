package com.cucumber.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:features/Camera.feature" }, glue = {
		"classpath:com.cucumber.bdd.steps" }, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json" })
public class CameraFeaturesRunner extends AbstractTestNGCucumberTests {
}
