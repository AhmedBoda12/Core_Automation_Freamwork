package com.boda.utils.actions;

import org.openqa.selenium.WebDriver;

import com.boda.utils.WaitManager;
import com.boda.utils.logs.LogsManager;

public class AlertActions {
    private final WebDriver driver;
    private final WaitManager waitManager;

    public AlertActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    public void acceptAlert() {
        waitManager.waitForElement().until(d -> {
            try {
                d.switchTo().alert().accept();
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to accept alert: ", e.getMessage());
                return false;
            }
        });
    }

    public void dismissAlert() {
        waitManager.waitForElement().until(d -> {
            try {
                d.switchTo().alert().dismiss();
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to dismiss alert: ", e.getMessage());
                return false;
            }
        });
    }

    public String getAlertText() {
        return waitManager.waitForElement().until(d -> {
            try {
                return d.switchTo().alert().getText().isEmpty() ? null : d.switchTo().alert().getText();
            } catch (Exception e) {
                LogsManager.error("Failed to get alert text: ", e.getMessage());
                return null;
            }
        });
    }

    public void sendTextToAlert(String text) {
        waitManager.waitForElement().until(d -> {
            try {
                d.switchTo().alert().sendKeys(text);
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to send text to alert: ", e.getMessage());
                return false;
            }
        });
    }
}
