package com.boda.utils.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.boda.utils.WaitManager;
import com.boda.utils.logs.LogsManager;

public class FrameActions {
    private final WebDriver driver;
    private final WaitManager waitManager;

    public FrameActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    public void switchToFrameByNameOrId(String nameOrId) {
        waitManager.waitForElement().until(d -> {
            try {
                d.switchTo().frame(nameOrId);
                LogsManager.info("Switched to frame: " + nameOrId);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void switchToFrameByIndex(int index) {
        waitManager.waitForElement().until(d -> {
            try {
                d.switchTo().frame(index);
                LogsManager.info("Switched to frame at index: " + index);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void switchToFrameByElement(By locator) {
        waitManager.waitForElement().until(d -> {
            try {
                d.switchTo().frame(d.findElement(locator));
                LogsManager.info("Switched to frame by element: " + locator);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void switchToDefaultContent() {
        waitManager.waitForElement().until(d -> {
            try {
                d.switchTo().defaultContent();
                LogsManager.info("Switched to default content");
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

}
