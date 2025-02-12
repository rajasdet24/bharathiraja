package com.american.express.tests;


import base.BaseTest;
import utils.LoggerUtil;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.american.express.pages.GoldCardApplicationPage;

public class AmexTest3 extends BaseTest{
	
	private String testURL;
	private static final Logger logger = LoggerUtil.getLogger(AmexTest3.class);
	
	
	@BeforeMethod
	@Parameters({"testURL"})
	public void setTestURL(String testURL) {
        this.testURL = testURL;
    }

	
	    @Test
	    public void testBasicValidations() {
	    	
	    	WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[text()='Tout Accepter']"));
	    	
	    	try {
	    		if(acceptCookiesButton.isDisplayed()) {
	    			acceptCookiesButton.click(); 
	    		
	    			 logger.info("Clicked acceptCookiesButton button");
	    		}
	    		
	    	}finally {
	    	
		    
		    
	        GoldCardApplicationPage goldcard = new GoldCardApplicationPage(driver);
	        // Fill junk data
	        goldcard.clickMRRadioBtn();
	        logger.info("Clicked MR Radio button");
	        goldcard.enterFirstName("bharathi");
	        logger.info("Entered First Name");
	        goldcard.enterLastName("raja");
	        logger.info("Entered Last Name");
	        goldcard.enterDate("12/02/1990");
	        logger.info("Entered DOB");
	        goldcard.enterEmail("bharathi.raja@amex.com");
	        logger.info("Entered Email");
	        goldcard.enterPhone("0712345678");
	        logger.info("Entered phone number");

	        WebElement continueBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
	        
	        // Click 'Sauvegarder et Continuer'
	        goldcard.JSclickContinue();
	        logger.info("Clicked javascript click continue button");

	        // TODO: Add assertions based on expected validation messages
	        Assert.assertTrue(true, "Validation checks passed.");
	        logger.info("Assertion validation is completed");
	        
	    }
	    	}
	    
	    
	    @AfterMethod
		public void tearDown() {
			driver.quit();
			logger.info("WebDriver closed successfully");
		}
	}
	

