package com.american.express.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.american.express.pages.HomePage;

import base.BaseTest;
import utils.ConfigReader;
import utils.LoggerUtil;

public class AmexTest2 extends BaseTest{
	
	private String testURL;
	private static final Logger logger = LoggerUtil.getLogger(AmexTest2.class);
	
	@BeforeMethod
	@Parameters({"testURL"})
	public void setTestURL(String testURL) {
        this.testURL = testURL;
    }


    @Test
    public void testGoldCardNavigation() {
     
        
        // Initialize Page Object
        HomePage homePage = new HomePage(driver);

        // Handle pop-up and navigation
        homePage.clickAndVerifyGoldAmericanExpress();

        // Verify new page URL
        Assert.assertTrue(driver.getCurrentUrl().contains("gold-card-americanexpress"), "Navigation to Gold Card page failed!");
   
        logger.info("Assertion is successfully completed");
    
    }
	    
	    
	    @AfterMethod
		public void tearDown() {
			driver.quit();
			logger.info("Web Driver is successfully completed");
		}
	}

