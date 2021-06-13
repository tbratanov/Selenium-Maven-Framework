package com.framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.concurrent.TimeUnit;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

import static junit.framework.TestCase.assertTrue;

public class UserActions {

    final WebDriver driver;

    public UserActions() {
        this.driver = Utils.getWebDriver();
    }

    // #### Opening/Closing Browser ####

    public static void loadBrowser() {
        Utils.getWebDriver().get(Utils.getConfigPropertyByKey("base.url"));
        Utils.LOG.info("Opening browsers.");
    }

    public static void quitBrowser() {
        Utils.tearDownWebDriver();
        Utils.LOG.info("Closing browser.");
    }

    // #### Waits ####

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void waitForElementVisible(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utils.getUIMappingByKey(locator))));
        Utils.LOG.info("Element "+locator+" is waited for "+ seconds + "sec. until it is visible.");
    }

    public void waitForElementNotVisible(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Utils.getUIMappingByKey(locator))));
        Utils.LOG.info("Element "+locator+" is waited for "+ seconds + "sec. until it is NOT visible.");
    }

    public void waitForElementClickable(String locator, int seconds) {
        WebDriverWait wait= new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Utils.getUIMappingByKey(locator))));
        Utils.LOG.info("Element " + locator + " is waited for " + seconds + " sec. until it is clickable.");
    }

    // #### User Actions ####

    public void clickElement(String key){
        waitForElementVisible(key, 3);
        WebElement element = driver.findElement(By.xpath(Utils.getUIMappingByKey(key)));
        element.click();
        Utils.LOG.info("Element " + key + " is clicked.");

    }

    public void typeValueInField(String value, String field){
        WebElement element = driver.findElement(By.xpath(Utils.getUIMappingByKey(field)));
        element.sendKeys(value);
        Utils.LOG.info("Value :" + value + " is typed in " + field+".");
    }

    public void assertElementPresent(String locator){
        Assert.assertNotNull(driver.findElement(By.xpath(Utils.getUIMappingByKey(locator))));
        Utils.LOG.info("Element " + locator + " is present.");
    }

    public void assertElementNotPresent(String locator) {
        Assert.assertEquals(0, driver.findElements(By.xpath(Utils.getUIMappingByKey(locator))).size());
        Utils.LOG.info("Element "+locator+" is not present.");
    }

    public void assertElementContains (String locator, String expectedResult){
        String actualString = driver.findElement(By.xpath(Utils.getUIMappingByKey(locator))).getText();
        String expectedString = expectedResult;
        assertTrue(actualString.contains(expectedString));
        Utils.LOG.info("Element " + locator + " contains " + expectedResult+".");
    }

    public void clearElementOfInput (String field){
        WebElement element = driver.findElement(By.xpath(Utils.getUIMappingByKey(field)));
        element.clear();
        Utils.LOG.info("Text in element " + field + " is cleared");
    }

    public void doubleClickElement (String key){
        waitForElementVisible(key, 3);
        WebElement element = driver.findElement(By.xpath(Utils.getUIMappingByKey(key)));
        Actions action = new Actions(driver);
        action.doubleClick(element);
        Utils.LOG.info("Element " + key + " is double clicked.");

    }

    public void clickAndHold (String key){
        waitForElementVisible(key, 3);
        WebElement element = driver.findElement(By.xpath(Utils.getUIMappingByKey(key)));
        Actions action = new Actions(driver);
        action.clickAndHold(element);
        Utils.LOG.info("Element " + key + " is clicked and held.");

    }

    public void dragAndDrop (String dragKey, String dropKey){
        waitForElementVisible(dragKey, 3);
        WebElement dragElement = driver.findElement(By.xpath(Utils.getUIMappingByKey(dragKey)));

        waitForElementVisible(dropKey, 3);
        WebElement dropElement = driver.findElement(By.xpath(Utils.getUIMappingByKey(dropKey)));


        Actions action = new Actions(driver);
        action.dragAndDrop(dragElement, dropElement);
        Utils.LOG.info("Element " + dragKey + " is dragged and dropped at element: "+ dropKey +"'s location.");
    }

}
