package com.boda.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstractDriver {

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        options.setAcceptInsecureCerts(true);
        return options;
    }

    @Override
    public WebDriver createDriver() {
        return new EdgeDriver(getEdgeOptions());
    }

}
