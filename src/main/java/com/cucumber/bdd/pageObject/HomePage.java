package com.cucumber.bdd.pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.bdd.utility.LoggerHelper;
import com.cucumber.bdd.utility.ObjectRepo;

public class HomePage {
	public HomePage() {
		driver = ObjectRepo.driver;
		base = new PageBase();
		PageFactory.initElements(driver, this);
	}

	int i = 1;
	private WebDriver driver;
	PageBase base;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	int explicitTimeout = 30;
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	public WebElement search;
	@FindBy(how = How.XPATH, using = "//*[@id=\"leftNavContainer\"]/h3[1]")
	public WebElement searchResult;
	@FindBy(how = How.XPATH, using = "//*[@id=\"nav-search\"]/form/div[2]/div/input")
	public WebElement searchButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sort\"]/option[3]")
	public WebElement sortResultAscending;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sort\"]/option[2]")
	public WebElement sortResultDescending;
	@FindBy(how = How.CLASS_NAME, using = "a-fixed-left-grid")
	public List<WebElement> selectItem;
	@FindBy(how = How.ID, using = "productTitle")
	public WebElement title;
	@FindBy(how = How.ID, using = "bylineInfo")
	public WebElement bylineInfo;

	public boolean launchUrl(String url) {
		log.info("Launching URL: " + url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
		if (base.waitForElement(search, 10)) {
			return true;
		}
		return false;
	}

	public boolean searchCamera(String item) {
		log.info("Searching Camera " + item);
		search.sendKeys(new CharSequence[] { item });
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
		if (base.waitForElement(searchResult, 10)) {
			return true;
		}
		return false;
	}

	public boolean sortTheResults(String ascDesc) throws InterruptedException {
		log.info("Sorting the prices based in " + ascDesc + " order");
		WebElement temp = null;
		if (ascDesc.equalsIgnoreCase("descending")) {
			temp = sortResultAscending;
		} else {
			temp = sortResultDescending;
		}
		temp.click();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		if (base.waitForElement(temp, 10)) {
			return true;
		}
		return false;
	}

	public String verifyTheSellerBrand() throws InterruptedException {
		log.info("Verifying the details of the first product ");
		List<WebElement> links = selectItem;
		int i = getIndexOnPage(links);
		((WebElement) links.get(i)).findElement(By.partialLinkText("Nikon")).click();
		return bylineInfo.getText();
	}

	public String verifyTheSecondResult(String modelName) {
		try {
			Thread.sleep(2500);
			driver.navigate().back();
			log.info("Verifying whether the following model is " + modelName);
			List<WebElement> links = selectItem;
			int i = getIndexOnPage(links);
			Thread.sleep(2500);
			((WebElement) links.get(i + 1)).findElement(By.partialLinkText("Nikon")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return title.getText();
	}

	private int getIndexOnPage(List<WebElement> links) {
		try {
			for (int i = 0; i < links.size(); i++) {
				if (((WebElement) links.get(i)).findElement(By.className("a-size-large a-color-base")).getText()
						.contains("Expert Recom")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;

					js.executeScript("window.scrollBy(0,2000)", new Object[0]);
					Thread.sleep(2000);
					i++;
				} else {
					return i;
				}
			}
		} catch (NoSuchElementException n) {
			return i;
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return 0;
	}
}
