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
public class Barcode4JResourceTest {

    @Test
    public void testBarcode4JCode39Png() {
        given()
                .when().get("/barcode4j/code39/png")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.PNG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(notNullValue());
    }

    @Test
    public void testBarcode4JCode39Svg() {
        given()
                .when().get("/barcode4j/code39/svg")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.SVG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(is(
                        "<?xml version=\"1.0\" encoding=\"UTF-8\"?><svg height=\"17.8219mm\" viewBox=\"0 0 40.76 17.8219\" width=\"40.76mm\" xmlns=\"http://www.w3.org/2000/svg\"><g fill=\"black\" stroke=\"none\"><rect height=\"15\" width=\"0.1693\" x=\"0\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"0.6773\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"1.016\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"1.6933\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"2.3707\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"2.73\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"3.0687\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"3.4073\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"3.746\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"4.762\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"5.46\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"6.476\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"6.8147\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"7.1533\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"7.492\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"8.19\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"8.8673\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"9.206\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"9.8833\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"10.222\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"10.92\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"11.5973\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"11.936\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"12.2747\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"13.2907\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"13.65\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"14.3273\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"14.666\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"15.0047\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"15.682\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"16.38\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"17.396\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"17.7347\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"18.0733\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"18.412\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"19.11\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"19.4487\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"20.126\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"20.4647\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"21.4807\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"21.84\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"22.5173\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"23.1947\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"23.5333\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"24.2107\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"24.57\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"25.2473\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"25.586\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"25.9247\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"26.9407\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"27.3\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"27.9773\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"28.316\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"28.9933\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"29.6707\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"30.03\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"30.7073\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"31.3847\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"32.062\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"32.4007\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"32.76\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"33.4373\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"33.776\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"34.1147\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"34.792\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"35.49\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"35.8287\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"36.506\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"36.8447\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"37.8607\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"38.22\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"38.8973\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"39.236\" y=\"0\"/><rect height=\"15\" width=\"0.508\" x=\"39.9133\" y=\"0\"/><rect height=\"15\" width=\"0.1693\" x=\"40.5907\" y=\"0\"/><text font-family=\"Helvetica\" font-size=\"2.8219\" text-anchor=\"middle\" x=\"20.38\" y=\"17.6228\">Quarkus Rocks</text></g></svg>"));
    }
}