package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Driver {

    //Creating a private constructor,
    // so we are closing access to the object of this class from outside the class.
    private Driver() {

    }

    //Private:we want to close access from outside the class
    //Static:we will use it in a static method
    // private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    //Getter for Webdriver
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            //read browserType from configuration.properties and use a switch to choose
            String browserType = ConfigurationReader.getProperty("browser");
            //if statement will determine which browser will be opened
            if (browserType.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driverPool.set(new ChromeDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driverPool.set( new FirefoxDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browserType.equalsIgnoreCase("safari")) {
                WebDriverManager.safaridriver().setup();
                driverPool.set(new SafariDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                System.out.println("Incorrect browser type in configuration.properties file for browser");
            }
        }
        return driverPool.get();
    }
    //This method wil make sure our driver value is always null after using quit()method
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit(); //this line will terminate the existing session. Value will not even be null
            driverPool.remove();
        }
    }
}

