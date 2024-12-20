package io.quarkiverse.barcode.it;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_LENGTH;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ZxingResourceTest {

    @Test
    public void testZxingQrPng() {
        given()
                .when().get("/zxing/qr/png")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.PNG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(notNullValue());
    }

}
