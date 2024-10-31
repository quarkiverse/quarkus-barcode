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
public class QrCodeGenResourceTest {

    @Test
    public void testQrCodeGenPng() {
        given()
                .when().get("/qrcodegen/qr/png")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.PNG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(notNullValue());
    }

    @Test
    public void testQrCodeGenSvg() {
        given()
                .when().get("/qrcodegen/qr/svg")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.SVG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(is(
                        """
                                <?xml version="1.0" encoding="UTF-8"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg xmlns="http://www.w3.org/2000/svg" version="1.1" viewBox="0 0 29 29" stroke="none"><rect width="100%" height="100%" fill="#FFFFFF"/><path d="M4,4h1v1h-1z M5,4h1v1h-1z M6,4h1v1h-1z M7,4h1v1h-1z M8,4h1v1h-1z M9,4h1v1h-1z M10,4h1v1h-1z M12,4h1v1h-1z M15,4h1v1h-1z M18,4h1v1h-1z M19,4h1v1h-1z M20,4h1v1h-1z M21,4h1v1h-1z M22,4h1v1h-1z M23,4h1v1h-1z M24,4h1v1h-1z M4,5h1v1h-1z M10,5h1v1h-1z M12,5h1v1h-1z M13,5h1v1h-1z M16,5h1v1h-1z M18,5h1v1h-1z M24,5h1v1h-1z M4,6h1v1h-1z M6,6h1v1h-1z M7,6h1v1h-1z M8,6h1v1h-1z M10,6h1v1h-1z M13,6h1v1h-1z M15,6h1v1h-1z M18,6h1v1h-1z M20,6h1v1h-1z M21,6h1v1h-1z M22,6h1v1h-1z M24,6h1v1h-1z M4,7h1v1h-1z M6,7h1v1h-1z M7,7h1v1h-1z M8,7h1v1h-1z M10,7h1v1h-1z M12,7h1v1h-1z M13,7h1v1h-1z M14,7h1v1h-1z M18,7h1v1h-1z M20,7h1v1h-1z M21,7h1v1h-1z M22,7h1v1h-1z M24,7h1v1h-1z M4,8h1v1h-1z M6,8h1v1h-1z M7,8h1v1h-1z M8,8h1v1h-1z M10,8h1v1h-1z M13,8h1v1h-1z M14,8h1v1h-1z M15,8h1v1h-1z M18,8h1v1h-1z M20,8h1v1h-1z M21,8h1v1h-1z M22,8h1v1h-1z M24,8h1v1h-1z M4,9h1v1h-1z M10,9h1v1h-1z M13,9h1v1h-1z M18,9h1v1h-1z M24,9h1v1h-1z M4,10h1v1h-1z M5,10h1v1h-1z M6,10h1v1h-1z M7,10h1v1h-1z M8,10h1v1h-1z M9,10h1v1h-1z M10,10h1v1h-1z M12,10h1v1h-1z M14,10h1v1h-1z M16,10h1v1h-1z M18,10h1v1h-1z M19,10h1v1h-1z M20,10h1v1h-1z M21,10h1v1h-1z M22,10h1v1h-1z M23,10h1v1h-1z M24,10h1v1h-1z M12,11h1v1h-1z M4,12h1v1h-1z M6,12h1v1h-1z M7,12h1v1h-1z M9,12h1v1h-1z M10,12h1v1h-1z M11,12h1v1h-1z M14,12h1v1h-1z M18,12h1v1h-1z M21,12h1v1h-1z M23,12h1v1h-1z M24,12h1v1h-1z M5,13h1v1h-1z M8,13h1v1h-1z M9,13h1v1h-1z M12,13h1v1h-1z M13,13h1v1h-1z M19,13h1v1h-1z M20,13h1v1h-1z M21,13h1v1h-1z M22,13h1v1h-1z M23,13h1v1h-1z M24,13h1v1h-1z M5,14h1v1h-1z M7,14h1v1h-1z M8,14h1v1h-1z M10,14h1v1h-1z M12,14h1v1h-1z M15,14h1v1h-1z M18,14h1v1h-1z M23,14h1v1h-1z M24,14h1v1h-1z M5,15h1v1h-1z M6,15h1v1h-1z M11,15h1v1h-1z M13,15h1v1h-1z M14,15h1v1h-1z M15,15h1v1h-1z M16,15h1v1h-1z M19,15h1v1h-1z M21,15h1v1h-1z M6,16h1v1h-1z M8,16h1v1h-1z M10,16h1v1h-1z M11,16h1v1h-1z M13,16h1v1h-1z M16,16h1v1h-1z M17,16h1v1h-1z M19,16h1v1h-1z M12,17h1v1h-1z M14,17h1v1h-1z M16,17h1v1h-1z M18,17h1v1h-1z M19,17h1v1h-1z M20,17h1v1h-1z M21,17h1v1h-1z M23,17h1v1h-1z M24,17h1v1h-1z M4,18h1v1h-1z M5,18h1v1h-1z M6,18h1v1h-1z M7,18h1v1h-1z M8,18h1v1h-1z M9,18h1v1h-1z M10,18h1v1h-1z M12,18h1v1h-1z M13,18h1v1h-1z M15,18h1v1h-1z M17,18h1v1h-1z M18,18h1v1h-1z M19,18h1v1h-1z M20,18h1v1h-1z M21,18h1v1h-1z M4,19h1v1h-1z M10,19h1v1h-1z M12,19h1v1h-1z M14,19h1v1h-1z M15,19h1v1h-1z M17,19h1v1h-1z M21,19h1v1h-1z M22,19h1v1h-1z M24,19h1v1h-1z M4,20h1v1h-1z M6,20h1v1h-1z M7,20h1v1h-1z M8,20h1v1h-1z M10,20h1v1h-1z M13,20h1v1h-1z M14,20h1v1h-1z M15,20h1v1h-1z M16,20h1v1h-1z M19,20h1v1h-1z M22,20h1v1h-1z M23,20h1v1h-1z M4,21h1v1h-1z M6,21h1v1h-1z M7,21h1v1h-1z M8,21h1v1h-1z M10,21h1v1h-1z M12,21h1v1h-1z M13,21h1v1h-1z M14,21h1v1h-1z M16,21h1v1h-1z M18,21h1v1h-1z M19,21h1v1h-1z M23,21h1v1h-1z M4,22h1v1h-1z M6,22h1v1h-1z M7,22h1v1h-1z M8,22h1v1h-1z M10,22h1v1h-1z M12,22h1v1h-1z M14,22h1v1h-1z M15,22h1v1h-1z M16,22h1v1h-1z M17,22h1v1h-1z M18,22h1v1h-1z M4,23h1v1h-1z M10,23h1v1h-1z M16,23h1v1h-1z M17,23h1v1h-1z M18,23h1v1h-1z M19,23h1v1h-1z M20,23h1v1h-1z M24,23h1v1h-1z M4,24h1v1h-1z M5,24h1v1h-1z M6,24h1v1h-1z M7,24h1v1h-1z M8,24h1v1h-1z M9,24h1v1h-1z M10,24h1v1h-1z M12,24h1v1h-1z M13,24h1v1h-1z M17,24h1v1h-1z M18,24h1v1h-1z M22,24h1v1h-1z" fill="#000000"/></svg>
                                """));
    }
}