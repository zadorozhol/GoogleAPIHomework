package org.prog.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class RestTests {

    @Test
    public void restTest() {
        Response resp = RestAssured.given()
                .get("https://randomuser.me/api/?inc=gender,name,nat&noinfo&gender=female");
        resp.body().prettyPrint();

        ValidatableResponse valid = resp.then();
        valid.statusCode(200);
    }
}
