package com.cucumber.bdd.helper.generic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cucumber.bdd.helper.browsers.ChromeBrowser;
import com.cucumber.bdd.helper.browsers.FirefoxBrowser;
import com.cucumber.bdd.utility.LoggerHelper;
import com.cucumber.bdd.utility.ObjectRepo;

public class InitializeWebDrive {
	private Logger oLog = LoggerHelper.getLogger(InitializeWebDrive.class);

	@SuppressWarnings("unlikely-arg-type")
	public WebDriver standAloneStepUp(String bType) throws Exception {
		try {
			oLog.info(bType);
			switch (bType) {
			case "Chrome":
				ChromeBrowser chrome = new ChromeBrowser();
				return chrome.getChromeDriver();
			case "Firefox":
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver();
			}
		} catch (Exception e) {
			oLog.equals(e);
			throw e;
		}
		return null;
	}

	public void setUpDriver(String bType) throws Exception {
		ObjectRepo.driver = standAloneStepUp(bType);
		oLog.debug("InitializeWebDrive : " + ObjectRepo.driver.hashCode());
		ObjectRepo.driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
		ObjectRepo.driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
		ObjectRepo.driver.manage().window().maximize();
	}

	public void tearDownDriver() throws Exception {
		try {
			if (ObjectRepo.driver != null) {
				ObjectRepo.driver.quit();
				ObjectRepo.driver = null;
				oLog.info("Shutting Down the driver");
			}
		} catch (Exception e) {
			oLog.error(e);
			throw e;
		}
	}
}
