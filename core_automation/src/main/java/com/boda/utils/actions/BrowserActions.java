package com.boda.utils.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import com.boda.utils.logs.LogsManager;

public class BrowserActions {
    private final WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
        LogsManager.info("Navigated to URL: " + url);
    }

    public String getCurrentUrl() {
        LogsManager.info("Current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closeCurrentWindow() {
        driver.close();
    }

    public void openNewTab(String url) {
        driver.switchTo().newWindow(WindowType.TAB);
    }


}
