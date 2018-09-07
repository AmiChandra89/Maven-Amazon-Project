package com.cucumber.bdd.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.bdd.utility.LoggerHelper;
import com.cucumber.bdd.utility.ObjectRepo;
import com.google.common.base.Function;

public class PageBase {
	private final Logger log = LoggerHelper.getLogger(PageBase.class);
	private WebDriver driver;

	public PageBase() {
		driver = ObjectRepo.driver;
	}

	public boolean waitForElement(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean flag = true;
		if (wait.until((elementLocated(element)))) {
			flag = true;
		}
		return flag;
	}

	private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				log.debug("Waiting for Element : " + element);
				return element.isDisplayed();
			}
		};
	}
}
