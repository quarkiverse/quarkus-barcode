package io.quarkiverse.barcode.it;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_LENGTH;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OkapiResourceTest {

    @Test
    public void testOkapiCode128Png() {
        given()
                .when().get("/okapi/code128/png")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.PNG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(notNullValue());
    }

    @Test
    public void testOkapiCode128Svg() {
        given()
                .when().get("/okapi/code128/svg")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.SVG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(is(
                        """
                                <?xml version="1.0" standalone="no"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg width="202" height="70" version="1.1" xmlns="http://www.w3.org/2000/svg"><desc>123456789</desc><g id="barcode" fill="#000000"><rect x="0" y="0" width="202" height="70" fill="#FFFFFF"/><rect x="0.00" y="0.00" width="4.00" height="50.00"/><rect x="6.00" y="0.00" width="2.00" height="50.00"/><rect x="12.00" y="0.00" width="6.00" height="50.00"/><rect x="22.00" y="0.00" width="2.00" height="50.00"/><rect x="26.00" y="0.00" width="4.00" height="50.00"/><rect x="34.00" y="0.00" width="6.00" height="50.00"/><rect x="44.00" y="0.00" width="2.00" height="50.00"/><rect x="52.00" y="0.00" width="2.00" height="50.00"/><rect x="56.00" y="0.00" width="4.00" height="50.00"/><rect x="66.00" y="0.00" width="6.00" height="50.00"/><rect x="78.00" y="0.00" width="2.00" height="50.00"/><rect x="82.00" y="0.00" width="4.00" height="50.00"/><rect x="88.00" y="0.00" width="4.00" height="50.00"/><rect x="100.00" y="0.00" width="2.00" height="50.00"/><rect x="104.00" y="0.00" width="2.00" height="50.00"/><rect x="110.00" y="0.00" width="2.00" height="50.00"/><rect x="114.00" y="0.00" width="8.00" height="50.00"/><rect x="124.00" y="0.00" width="6.00" height="50.00"/><rect x="132.00" y="0.00" width="6.00" height="50.00"/><rect x="142.00" y="0.00" width="2.00" height="50.00"/><rect x="146.00" y="0.00" width="4.00" height="50.00"/><rect x="154.00" y="0.00" width="2.00" height="50.00"/><rect x="162.00" y="0.00" width="8.00" height="50.00"/><rect x="172.00" y="0.00" width="2.00" height="50.00"/><rect x="176.00" y="0.00" width="4.00" height="50.00"/><rect x="186.00" y="0.00" width="6.00" height="50.00"/><rect x="194.00" y="0.00" width="2.00" height="50.00"/><rect x="198.00" y="0.00" width="4.00" height="50.00"/><text x="101.00" y="66.00" text-anchor="middle" font-family="Monospaced" font-size="16.00" fill="#000000"> 123456789 </text></g></svg>
                                """));
    }
}