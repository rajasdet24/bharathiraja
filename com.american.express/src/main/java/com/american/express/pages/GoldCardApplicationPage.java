package com.american.express.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoldCardApplicationPage {
	
	    private WebDriver driver;

	    // Locators
	    private By firstNameField = By.name("firstName");
	    private By lastNameField = By.name("lastName");
	    private By emailField = By.name("email");
	    private By phoneField = By.name("mobilePhoneNumber");
	    private By continueButton = By.xpath("//button[@type='submit']");
	    private By radioMRBtn = By.xpath("//label[@for='MR']/span");
	    private By dateTextBox = By.name("fieldControl-input-dateOfBirth");

	    public GoldCardApplicationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void enterFirstName(String firstName) {
	        driver.findElement(firstNameField).sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        driver.findElement(lastNameField).sendKeys(lastName);
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPhone(String phone) {
	        driver.findElement(phoneField).sendKeys(phone);
	    }

	    public void JSclickContinue() {
	    	
	      WebElement contBtn =  driver.findElement(By.xpath("//button[@type='submit']"));
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", contBtn);
	    }
	    
	    public void clickMRRadioBtn() {
	    	driver.findElement(radioMRBtn).click();
	    }
	    
	    public void enterDate(String date) {
	    	driver.findElement(dateTextBox).sendKeys(date);
	    }
	}



