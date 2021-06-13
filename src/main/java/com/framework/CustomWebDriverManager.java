package com.framework;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import java.io.File;

public class CustomWebDriverManager {
    public enum customWebDriverManagerEnum {

        INSTANCE;
        private WebDriver driver = setupBrowser();

        private WebDriver setupBrowser () {
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File("C:/Users/Acer/Downloads/extension_1_35_2_0.crx"));
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            WebDriver chromeDriver = new ChromeDriver(options);
            chromeDriver.manage().window().maximize();
            return chromeDriver;
        }

        public void quitDriver() {
            if(driver != null){
                driver.quit();
            }
        }

        public WebDriver getDriver() {
            return driver;
        }
    }
}
