package com.cucumber.bdd.steps;

import com.cucumber.bdd.helper.generic.InitializeTestCase;
import com.cucumber.bdd.utility.LoggerHelper;
import com.cucumber.bdd.pageObject.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class CameraSteps {
	InitializeTestCase init;
	HomePage home;
	private Logger oLog = LoggerHelper.getLogger(CameraSteps.class);

	@Before
	public void preRunSetupChrome() {
		oLog.info("**************Starting Test Case*******************");
		init = new InitializeTestCase();
		init.initiateBroweser("Chrome");// For running it in Firefox, replace Chrome with Firefox
		home = new HomePage();
	}

	@Given("^: The user is able to navigate to \"([^\"]*)\"$")
	public void the_user_is_able_to_navigate_to(String arg1) throws Throwable {
		if (home.launchUrl(arg1)) {
			oLog.info(arg1 + " Has been launched successfully");
		}
	}

	@When("^: User tried to search \"([^\"]*)\" in search filter and sort in \\\"([^\\\"]*)\\\" order$")
	public void user_tried_to_search_in_search_filter_and_sort_in_order(String arg1, String arg2) throws Throwable {
		if (home.searchCamera(arg1)) {
			oLog.info(arg1 + " Has been searched successfully");
			if (home.sortTheResults(arg2)) {
				oLog.info("Result has been sorted successfully in " + arg2 + " order");
			}
		}
	}

	@Then("^: Verify the seller brand$")
	public void verify_the_seller_brand() throws Throwable {
		String sellerBrand = home.verifyTheSellerBrand();
		oLog.info("The seller brand is " + sellerBrand);
		try {
			Assert.assertTrue(sellerBrand.contains("Nikon"));
			oLog.info("Product is sold by Nikon");
		} catch (Exception e) {
			oLog.info("Product is not sold by Nikon");
		}
	}

	@Then("^: Verify that the second entry is \"([^\"]*)\"$")
	public void verify_that_the_second_entry_is(String arg1) throws Throwable {
		String productName = home.verifyTheSecondResult(arg1);
		oLog.info("Product Name is: " + productName);
		try {
			Assert.assertTrue(productName.contains(arg1));
			oLog.info("Product has been found");
		} catch (Exception e) {
			oLog.info("Product " + arg1 + " has not been found");
		}
	}

	@After
	public void preRunSetup() {
		try {
			init.terminateDrivers();
			oLog.info("**************Test case completed*******************");
		} catch (Exception e) {
			oLog.debug(e);
		}
	}
}
