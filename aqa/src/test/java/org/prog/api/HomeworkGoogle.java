package org.prog.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prog.dto.RandomUserResults;
import org.prog.web.BaseTest;
import org.prog.web.pageobjects.GooglePage;

import java.util.List;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class HomeworkGoogle extends BaseTest {
    private final static String EXPECTED_randomName = "Cole Finder";

    private static GooglePage googlePage;

    @BeforeAll
    public static void setup() {
        googlePage = new GooglePage(driver);
    }

    @BeforeEach
    public void loadPage() {
        googlePage.loadPage();
    }


    @Test

    public void randomNameFind() {

        Response resp = RestAssured.given()
                .get("https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=1");
        RandomUserResults dto = resp.as(RandomUserResults.class);
        dto.getResults().stream().forEach(r -> System.out.println(r.getName().getFirst()));
        dto.getResults().stream().forEach(r -> System.out.println(r.getName().getLast()));
    }

    public static final Configuration NEW_PATH_CONFIGURATION = Configuration.builder()
            .options(Option.DEFAULT_PATH_LEAF_TO_NULL, Option.SUPPRESS_EXCEPTIONS)
            .jsonProvider(new JacksonJsonProvider(new ObjectMapper()))
            .mappingProvider(new JacksonMappingProvider(new ObjectMapper()))
            .build();

    @Test

    public void randomNameGoogleCheck() {

        googlePage.onAds().setRandomNameSearch("Ondino Novaes");
        googlePage.onAds().findSearch();
        googlePage.onAds().checkText();
        Assert.assertEquals("Title name mismatch!", "Ondina Novaes | Facebook",
                googlePage.onAds().checkText());

        //        googlePage.onAds().checkRandomName("unknown");
//        Assert.assertEquals("Title name mismatch!", "Cole Finder",
//                googlePage.onAds().checkRandomName());

    }

}

