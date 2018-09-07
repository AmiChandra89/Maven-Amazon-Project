package com.cucumber.bdd.helper.browsers;

import com.cucumber.bdd.utility.GenericUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser
{
  public WebDriver getFirefoxDriver()
  {
    System.setProperty("webdriver.gecko.driver", GenericUtility.getResourcePath("drivers/geckodriver.exe"));
    return new FirefoxDriver();
  }
}
