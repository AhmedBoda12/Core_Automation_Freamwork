package com.boda.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.boda.utils.WaitManager;
import com.boda.utils.actions.ElementActions;

public abstract class BaseAssertion {
    protected WebDriver driver;
    protected WaitManager waitManager;
    protected ElementActions elementActions;

    public BaseAssertion(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
        this.elementActions = new ElementActions(driver);
    }

    protected abstract void assertTrue(boolean condition, String message);

    protected abstract void assertFalse(boolean condition, String message);

    protected abstract void assertEquals(Object actual, Object expected, String message);

    protected abstract void assertNotNull(Object object, String message);

    protected abstract void assertNull(Object object, String message);

    protected abstract void assertContains(String actual, String expected, String message);

    protected abstract void assertNotContains(String actual, String expected, String message);

    protected void equals(Object actual, Object expected, String message) {
        assertEquals(actual, expected, message);
    }

    protected void notEquals(Object actual, Object expected, String message) {
        assertFalse(actual.equals(expected), message);
    }

    protected void contains(String actual, String expected, String message) {
        assertContains(actual, expected, message);
    }

    protected void notContains(String actual, String expected, String message) {
        assertNotContains(actual, expected, message);
    }

    protected void isTrue(boolean condition, String message) {
        assertTrue(condition, message);
    }

    protected void isFalse(boolean condition, String message) {
        assertFalse(condition, message);
    }

    protected void isNotNull(Object object, String message) {
        assertNotNull(object, message);
    }

    protected void isNull(Object object, String message) {
        assertNull(object, message);
    }

    protected void isElementVisible(By locator, String message) {
        boolean isVisible = waitManager.waitForElement().until(d -> {
            try {
                d.findElement(locator).isDisplayed();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
        assertTrue(isVisible, message);

    }

    protected void isElementNotVisible(By locator, String message) {
        boolean isNotVisible = waitManager.waitForElement().until(d -> {
            try {
                return !d.findElement(locator).isDisplayed();
            } catch (Exception e) {
                return true;
            }
        });
        assertTrue(isNotVisible, message);
    }

    protected void assertElementText(By locator, String expectedText, String message) {
        String actualText = elementActions.getText(locator);
        assertEquals(actualText, expectedText, message);
    }

    protected void assertPageTitle(String expectedTitle, String message) {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle, message);
    }

    protected void assertPageURL(String expectedURL, String message) {
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL, message);
    }
}
