package com.american.express.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.american.express.pages.HomePage;

import org.testng.AssertJUnit;
import org.testng.ITestContext;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.LoggerUtil;

public class AmexTest1 extends BaseTest{
	
	private String testURL;
	private static final Logger logger = LoggerUtil.getLogger(AmexTest1.class);


	@BeforeMethod
	@Parameters({"testURL"})
	public void setTestURL(String testURL) {
        this.testURL = testURL;
        driver.get(testURL);
    }

	@Test
	public void testNavigateToCartesAmericanExpress() {

		
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement acceptCookiesButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Tout Accepter']")));
	    
	    acceptCookiesButton.click();
	    logger.info("Clicked acceptCookiesButton button");


		WebElement cartesLink = driver.findElement(By.xpath("//p[contains(text(),'Cartes American Express®')]"));
		cartesLink.click();
		logger.info("Clicked cartesLink button");

		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Cartes"), "Navigation to 'Cartes American Express' failed!");
		logger.info("Assertion is completed");
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
		logger.info("Web Driver is closed successfully");
	}
}
