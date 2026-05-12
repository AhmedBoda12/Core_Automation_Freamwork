package com.boda.validations;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.boda.utils.logs.LogsManager;

public class Validation extends BaseAssertion {
    private static SoftAssert softAssert = new SoftAssert();
    private static boolean used = false;

    public Validation(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void assertTrue(boolean condition, String message) {
        used = true;
        softAssert.assertTrue(condition, message);
    }

    @Override
    protected void assertFalse(boolean condition, String message) {
        used = true;

        softAssert.assertFalse(condition, message);
    }

    @Override
    protected void assertEquals(Object actual, Object expected, String message) {
        used = true;

        softAssert.assertEquals(actual, expected, message);
    }

    @Override
    protected void assertNotNull(Object object, String message) {
        used = true;
        softAssert.assertNotNull(object, message);
    }

    @Override
    protected void assertNull(Object object, String message) {
        used = true;
        softAssert.assertNull(object, message);
    }

    @Override
    protected void assertContains(String actual, String expected, String message) {
        used = true;
        softAssert.assertTrue(actual.contains(expected), message);
    }

    @Override
    protected void assertNotContains(String actual, String expected, String message) {
        used = true;
        softAssert.assertFalse(actual.contains(expected), message);
    }

    public static void assertAll() {
        if (!used)
            return; // No assertions were made, so skip assertAll
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            LogsManager.error("Soft assertion failed: " + e.getMessage());
        } finally {
            softAssert = new SoftAssert(); // Reset soft assertions for the next test
        }
    }
}
