package com.cucumber.bdd.helper.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.bdd.utility.GenericUtility;



public class ChromeBrowser {
	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", GenericUtility.getResourcePath("drivers/chromedriver.exe"));

		return new ChromeDriver();
	}
}
