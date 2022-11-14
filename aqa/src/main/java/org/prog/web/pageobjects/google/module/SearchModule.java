package org.prog.web.pageobjects.google.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.web.pageobjects.commons.AbstractModule;

import java.time.Duration;

import static org.openqa.selenium.Keys.RETURN;

public class SearchModule extends AbstractModule {
    public SearchModule(WebDriver driver) {
        super(driver);
    }

    private final static By GOOGLE_SEARCH  = By.xpath("//input[@name='q']");
    private final static By GOOGLE_SEARCH_RESULTS = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']");


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void setRandomNameSearch(String searchValue) {

        try {
            driver.findElement(GOOGLE_SEARCH).sendKeys(searchValue);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void findSearch() {

        try {
            driver.findElement(GOOGLE_SEARCH).sendKeys(RETURN);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

//    public void checkRandomName (String value) {
//        try {
//            driver.findElements(GOOGLE_SEARCH_RESULTS).stream()
//                    .filter(webElement -> webElement.getText().contains(value))
//                    .findAny()
//                    .ifPresent(WebElement::getText);
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        public String checkText() {
            return driver.findElement(GOOGLE_SEARCH_RESULTS).getText();
        }

    }


