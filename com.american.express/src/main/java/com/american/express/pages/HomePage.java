package com.american.express.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LoggerUtil;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public By creditCardLink = By.linkText("Cartes American Express");

    private static final Logger logger = LoggerUtil.getLogger(HomePage.class);
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCreditCardLink() {
        driver.findElement(creditCardLink).click();
    }
    
    
    public void clickAndVerifyGoldAmericanExpress() {
    	
    	WebElement goldCardSection = driver.findElement(By.xpath("//h2[contains(text(),'Carte Gold American Express')]"));
        WebElement enSavoirPlusBtn = driver.findElement(By.xpath("//h2[contains(text(),'Carte Gold American Express')]/following::a[1]/span[contains(text(),'En savoir plus')]"));

        WebElement acceptCookiesButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Tout Accepter']")));
	    
	    acceptCookiesButton.click();
	    logger.info("Clicked acceptCookiesButton button");
    	
        wait.until(
                ExpectedConditions.visibilityOf(goldCardSection));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goldCardSection);

        
        wait.until(
               ExpectedConditions.elementToBeClickable(enSavoirPlusBtn));

       enSavoirPlusBtn.click();
       logger.info("Clicked enSavoirPlusBtn button");

        
    }
}
