package com.boda.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends AbstractDriver {

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        options.setAcceptInsecureCerts(true);
        return options;
    }

    @Override
    public WebDriver createDriver() {

        return new ChromeDriver(getChromeOptions());
    }

}
