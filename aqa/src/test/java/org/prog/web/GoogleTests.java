//package org.prog.web;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.prog.dto.RandomUserResults;
//import org.prog.web.pageobjects.GooglePage;
//
//import java.util.stream.Stream;
//
//public class GoogleTests extends BaseTest {
//
//    private final static String EXPECTED_COVID_TEXT = "PCR-test visar om du har covid-19 - Folkhälsomyndigheten";
//    private final static String EXPECTED_MUSK_TEXT = "Elon Musk - Wikipedia";
//    private final static String HENDRIX = "Jimi Hendrix - Wikipedia";
//    private final static String RandomUser = "Can Decdeli";
//    private static GooglePage googlePage;
//
//    @BeforeAll
//    public static void setUpPageObject() {
//        googlePage = new GooglePage(driver);
//    }
//
//    @BeforeEach
//    public void preTest() {
//        googlePage.loadPage();
////        googlePage.acceptCookies();
//    }
//
//    @AfterEach
//    public void postTest() {
//        System.out.println("post any test");
//    }
//
//    @ParameterizedTest
//    @MethodSource("googleSearchProvider")
//
//
//    public void googleSearchAPITest(String searchValue, String searchResultValue, String headerValue) {
//        googlePage.setSearchValue(searchValue);
//        googlePage.performSearch(false);
//
//        Assertions.assertTrue(googlePage.getSearchResults().contains(searchResultValue),
//                "search results did not contain expected text");
//
//        if (headerValue != null) {
//            Assertions.assertEquals(googlePage.getHeaderText(), headerValue);
//        }
//    }
//
//    private static Stream<Arguments> googleSearchProvider() {
//        return Stream.of(
//                Arguments.of("Can Decdeli",RandomUser,"Can Decdeli")
//        );
//    }
//}
