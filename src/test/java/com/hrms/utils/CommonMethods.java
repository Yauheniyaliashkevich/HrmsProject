package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

   protected static WebDriver driver;

    /**
     * This method opens browser and navigates to the url
     */
    @BeforeMethod(alwaysRun = true)
    public static void setUp(){
       // ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        ConfigReader.readProperties(Constants.CONFIGURATION_FILE);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid name of browser");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    /**
     * This method closes all instances of the WebDriver
     */
    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     *  This method is sending text to any textBox
     * @param element
     * @param textToSend
     */
    public static void sendText (WebElement element, String textToSend ){
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     *  This method creates an object of WebDriverWait
     * @return WebDriverWait
     */
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * this method will wait till element becomes clickable
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method will wait till element becomes visible
     * @param element
     */
    public static void waitForVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * this method check if element is displayed
     * @param element
     * @return boolean
     */
    public static boolean displayed(WebElement element){
        waitForVisibility(element);
        return element.isDisplayed();
    }


}
