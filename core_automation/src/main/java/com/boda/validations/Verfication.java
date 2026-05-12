package com.boda.validations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Verfication extends BaseAssertion {

    public Verfication(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Override
    protected void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    @Override
    protected void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Override
    protected void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }

    @Override
    protected void assertNull(Object object, String message) {
        Assert.assertNull(object, message);
    }

    @Override
    protected void assertContains(String actual, String expected, String message) {
        Assert.assertTrue(actual.contains(expected), message);
    }

    @Override
    protected void assertNotContains(String actual, String expected, String message) {
        Assert.assertFalse(actual.contains(expected), message);
    }

}

