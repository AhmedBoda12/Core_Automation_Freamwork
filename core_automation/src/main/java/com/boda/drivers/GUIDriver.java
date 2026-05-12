package com.boda.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import com.boda.utils.dateReader.PropertyReader;
import com.boda.utils.logs.LogsManager;


public class GUIDriver {

    private final String browser = PropertyReader.getProperty("browserType");

    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver() {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        LogsManager.info("Initializing WebDriver for browser: " + browserType);
        AbstractDriver driverFactory = browserType.getDriverFactory();
        WebDriver driver = ThreadGuard.protect(driverFactory.createDriver());
        driverThreadLocal.set(driver);  
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

}
