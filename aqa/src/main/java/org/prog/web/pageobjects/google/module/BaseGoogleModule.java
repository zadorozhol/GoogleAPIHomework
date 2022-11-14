package org.prog.web.pageobjects.google.module;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseGoogleModule {
    protected WebDriver driver;

    public BaseGoogleModule (WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


}
