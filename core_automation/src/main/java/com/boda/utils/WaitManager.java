package com.boda.utils;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitManager {
    private final WebDriver driver;

    public WaitManager(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> waitForElement() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoreAll(getExpectedExceptions());
    }

    public ArrayList<Class<? extends Exception>> getExpectedExceptions() {
        ArrayList<Class<? extends Exception>> expectedExceptions = new ArrayList<>();
        expectedExceptions.add(NoSuchElementException.class);
        expectedExceptions.add(StaleElementReferenceException.class);
        expectedExceptions.add(ElementNotInteractableException.class);
        expectedExceptions.add(ElementClickInterceptedException.class);

        return expectedExceptions;
    }
}
