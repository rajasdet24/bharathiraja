package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import utils.ConfigReader;
import utils.LoggerUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;


public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger logger = LoggerUtil.getLogger(BaseTest.class);

    @BeforeClass
    @Parameters({"browser", "testURL"})
    public void setUp(String browser,String baseURL) {

    	logger.info("Initializing WebDriver...");
    	
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        // Configure WebDriver timeouts and wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // Navigate to the base URL
        driver.get(baseURL);
        logger.info("Navigated to Amex URL Page");
    }

    // Common method to wait for an element to be visible
    protected void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Web Driver closed successfully");
        }
    }
}

