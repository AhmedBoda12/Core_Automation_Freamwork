package com.boda.utils.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.boda.utils.WaitManager;

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
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

}
