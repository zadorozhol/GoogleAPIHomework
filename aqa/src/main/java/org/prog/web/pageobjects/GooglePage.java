package org.prog.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.commons.AbstractPage;
import org.prog.web.pageobjects.google.module.SearchModule;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePage extends AbstractPage {

    private static final String URL = "https://google.com/";

    private final SearchModule searchModule;


    public GooglePage (WebDriver driver) {
        super(driver, URL);
        searchModule = new SearchModule(driver);

    }
    public SearchModule onAds() {
        return searchModule;
    }

}