package com.boda.utils.actions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.boda.utils.WaitManager;
import com.boda.utils.logs.LogsManager;

public class ElementActions {
    private final WebDriver driver;
    private final WaitManager waitManager;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        waitManager = new WaitManager(driver);
    }

    public void click(By locator) {
        waitManager.waitForElement().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElement(locator);
                element.click();
                LogsManager.info("Clicked on element: " + locator);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void type(By locator, String text) {
        waitManager.waitForElement().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElement(locator);
                element.clear();
                element.sendKeys(text);
                LogsManager.info("Typed '" + text + "' into element: " + locator);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public String getText(By locator) {
        return waitManager.waitForElement().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElement(locator);
                LogsManager.info("Retrieved text: '" + element.getText() + "' from element: " + locator);
                return element.getText().isEmpty() ? null : element.getText();
            } catch (Exception e) {
                return null;
            }
        });
    }

    public void uploadFile(By locator, String filePath) {
        String absolutePath = System.getProperty("user.dir") + File.separator + filePath;
        waitManager.waitForElement().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElement(locator);
                element.sendKeys(absolutePath);
                LogsManager.info("Uploaded file: " + filePath + " into element: " + locator);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void scrollToElement(By locator) {
        try {
            ((JavascriptExecutor) driver)
                    .executeScript("""
                            arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});""",
                            findElement(locator));
        } catch (Exception e) {
            new Actions(driver).scrollToElement(findElement(locator));
        }

    }

}
