package io.quarkiverse.barcode.it;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_LENGTH;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

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

    @Test
    public void testOkapiCode128Postscript() {
        given()
                .when().get("/okapi/code128/eps")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.POSTSCRIPT_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(is(
                        """
                                %!PS-Adobe-3.0 EPSF-3.0
                                %%Creator: OkapiBarcode
                                %%Title: 123456789
                                %%Pages: 0
                                %%BoundingBox: 0 0 202 70
                                %%EndComments
                                /TL { setlinewidth moveto lineto stroke } bind def
                                /TC { moveto 0 360 arc 360 0 arcn fill } bind def
                                /TH { 0 setlinewidth moveto lineto lineto lineto lineto lineto closepath fill } bind def
                                /TB { 2 copy } bind def
                                /TR { newpath 4 1 roll exch moveto 1 index 0 rlineto 0 exch rlineto neg 0 rlineto closepath fill } bind def
                                /TE { pop pop } bind def
                                newpath
                                0.00 0.00 0.00 setrgbcolor
                                1.00 1.00 1.00 setrgbcolor
                                70.00 0.00 TB 0.00 202.00 TR
                                TE
                                0.00 0.00 0.00 setrgbcolor
                                50.00 20.00 TB 0.00 4.00 TR
                                TB 6.00 2.00 TR
                                TB 12.00 6.00 TR
                                TB 22.00 2.00 TR
                                TB 26.00 4.00 TR
                                TB 34.00 6.00 TR
                                TB 44.00 2.00 TR
                                TB 52.00 2.00 TR
                                TB 56.00 4.00 TR
                                TB 66.00 6.00 TR
                                TB 78.00 2.00 TR
                                TB 82.00 4.00 TR
                                TB 88.00 4.00 TR
                                TB 100.00 2.00 TR
                                TB 104.00 2.00 TR
                                TB 110.00 2.00 TR
                                TB 114.00 8.00 TR
                                TB 124.00 6.00 TR
                                TB 132.00 6.00 TR
                                TB 142.00 2.00 TR
                                TB 146.00 4.00 TR
                                TB 154.00 2.00 TR
                                TB 162.00 8.00 TR
                                TB 172.00 2.00 TR
                                TB 176.00 4.00 TR
                                TB 186.00 6.00 TR
                                TB 194.00 2.00 TR
                                TB 198.00 4.00 TR
                                TE
                                0.00 0.00 0.00 setrgbcolor
                                matrix currentmatrix
                                /Monospaced findfont
                                16.00 scalefont setfont 0 0 moveto 101.00 4.00 translate 0.00 rotate 0 0 moveto (123456789) stringwidth
                                pop
                                -2 div 0 rmoveto (123456789) show
                                setmatrix showpage
                                """));
    }

    @Test
    public void testOkapiEan13Base64Png() {
        given()
                .when().get("/okapi/ean13/png/base64")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.PNG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(startsWith(
                        "data:image/png;base64,77+9UE5HDQoaCgAAAA1JSERSAAABLAAAASwIAAAAAF"));
    }

    @Test
    public void testOkapiEan13Base64Svg() {
        given()
                .when().get("/okapi/ean13/svg/base64")
                .then()
                .statusCode(200)
                .contentType(equalTo(BaseImageResource.SVG_MIME_TYPE))
                .header(CONTENT_LENGTH, Integer::parseInt, greaterThan(0))
                .body(is(
                        "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBzdGFuZGFsb25lPSJubyI/Pgo8IURPQ1RZUEUgc3ZnIFBVQkxJQyAiLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4iCiAgICJodHRwOi8vd3d3LnczLm9yZy9HcmFwaGljcy9TVkcvMS4xL0RURC9zdmcxMS5kdGQiPgo8c3ZnIHdpZHRoPSIzMDIiIGhlaWdodD0iMTAwIiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CiAgIDxkZXNjPjEyMzQ1Njc4OTAxMjwvZGVzYz4KICAgPGcgaWQ9ImJhcmNvZGUiIGZpbGw9IiMwMDAwMDAiPgogICAgICA8cmVjdCB4PSIwIiB5PSIwIiB3aWR0aD0iMzAyIiBoZWlnaHQ9IjEwMCIgZmlsbD0iI0ZGRkZGRiIgLz4KICAgICAgPHJlY3QgeD0iMC4wMCIgeT0iMC4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iOTAuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjQuMDAiIHk9IjAuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9IjkwLjAwIiAvPgogICAgICA8cmVjdCB4PSIxMC4wMCIgeT0iMC4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iODAuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjE2LjAwIiB5PSIwLjAwIiB3aWR0aD0iNC4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMjIuMDAiIHk9IjAuMDAiIHdpZHRoPSI4LjAwIiBoZWlnaHQ9IjgwLjAwIiAvPgogICAgICA8cmVjdCB4PSIzMi4wMCIgeT0iMC4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iODAuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjM4LjAwIiB5PSIwLjAwIiB3aWR0aD0iNi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iNDYuMDAiIHk9IjAuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9IjgwLjAwIiAvPgogICAgICA8cmVjdCB4PSI1MC4wMCIgeT0iMC4wMCIgd2lkdGg9IjQuMDAiIGhlaWdodD0iODAuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjYwLjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iNzAuMDAiIHk9IjAuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9IjgwLjAwIiAvPgogICAgICA8cmVjdCB4PSI3NC4wMCIgeT0iMC4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iODAuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjgwLjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iODguMDAiIHk9IjAuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9IjgwLjAwIiAvPgogICAgICA8cmVjdCB4PSI5Mi4wMCIgeT0iMC4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iOTAuMDAiIC8+CiAgICAgIDxyZWN0IHg9Ijk2LjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI5MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTAwLjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTA2LjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTE0LjAwIiB5PSIwLjAwIiB3aWR0aD0iNi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTIyLjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTI4LjAwIiB5PSIwLjAwIiB3aWR0aD0iNi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTM4LjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTQyLjAwIiB5PSIwLjAwIiB3aWR0aD0iNC4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTUwLjAwIiB5PSIwLjAwIiB3aWR0aD0iNC4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTU2LjAwIiB5PSIwLjAwIiB3aWR0aD0iNC4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTYyLjAwIiB5PSIwLjAwIiB3aWR0aD0iNC4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTcwLjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTc2LjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI4MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTg0LjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI5MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMTg4LjAwIiB5PSIwLjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI5MC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMjA4LjAwIiB5PSIxNi4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iNzQuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjIxMi4wMCIgeT0iMTYuMDAiIHdpZHRoPSI0LjAwIiBoZWlnaHQ9Ijc0LjAwIiAvPgogICAgICA8cmVjdCB4PSIyMTguMDAiIHk9IjE2LjAwIiB3aWR0aD0iNC4wMCIgaGVpZ2h0PSI3NC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMjI2LjAwIiB5PSIxNi4wMCIgd2lkdGg9IjQuMDAiIGhlaWdodD0iNzQuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjIzMi4wMCIgeT0iMTYuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9Ijc0LjAwIiAvPgogICAgICA8cmVjdCB4PSIyMzguMDAiIHk9IjE2LjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI3NC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMjQ0LjAwIiB5PSIxNi4wMCIgd2lkdGg9IjQuMDAiIGhlaWdodD0iNzQuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjI1MC4wMCIgeT0iMTYuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9Ijc0LjAwIiAvPgogICAgICA8cmVjdCB4PSIyNTQuMDAiIHk9IjE2LjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI3NC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMjY0LjAwIiB5PSIxNi4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iNzQuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjI2OC4wMCIgeT0iMTYuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9Ijc0LjAwIiAvPgogICAgICA8cmVjdCB4PSIyNzIuMDAiIHk9IjE2LjAwIiB3aWR0aD0iMi4wMCIgaGVpZ2h0PSI3NC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMjgwLjAwIiB5PSIxNi4wMCIgd2lkdGg9IjQuMDAiIGhlaWdodD0iNzQuMDAiIC8+CiAgICAgIDxyZWN0IHg9IjI4Ni4wMCIgeT0iMTYuMDAiIHdpZHRoPSIyLjAwIiBoZWlnaHQ9Ijc0LjAwIiAvPgogICAgICA8cmVjdCB4PSIyOTAuMDAiIHk9IjE2LjAwIiB3aWR0aD0iNC4wMCIgaGVpZ2h0PSI3NC4wMCIgLz4KICAgICAgPHJlY3QgeD0iMzAwLjAwIiB5PSIxNi4wMCIgd2lkdGg9IjIuMDAiIGhlaWdodD0iNzQuMDAiIC8+CiAgICAgIDx0ZXh0IHg9Ii0xMC4wMCIgeT0iOTYuMDAiIHRleHQtYW5jaG9yPSJlbmQiCiAgICAgICAgIGZvbnQtZmFtaWx5PSJIZWx2ZXRpY2EiIGZvbnQtc2l6ZT0iMTYuMDAiIGZpbGw9IiMwMDAwMDAiPgogICAgICAgICAxCiAgICAgIDwvdGV4dD4KICAgICAgPHRleHQgeD0iMTAuMDAiIHk9Ijk2LjAwIiB0ZXh0LWFuY2hvcj0ic3RhcnQiCiAgICAgICAgIHRleHRMZW5ndGg9Ijc4LjAwIiBsZW5ndGhBZGp1c3Q9InNwYWNpbmciCiAgICAgICAgIGZvbnQtZmFtaWx5PSJIZWx2ZXRpY2EiIGZvbnQtc2l6ZT0iMTYuMDAiIGZpbGw9IiMwMDAwMDAiPgogICAgICAgICAyMzQ1NjcKICAgICAgPC90ZXh0PgogICAgICA8dGV4dCB4PSIxMDIuMDAiIHk9Ijk2LjAwIiB0ZXh0LWFuY2hvcj0ic3RhcnQiCiAgICAgICAgIHRleHRMZW5ndGg9Ijc4LjAwIiBsZW5ndGhBZGp1c3Q9InNwYWNpbmciCiAgICAgICAgIGZvbnQtZmFtaWx5PSJIZWx2ZXRpY2EiIGZvbnQtc2l6ZT0iMTYuMDAiIGZpbGw9IiMwMDAwMDAiPgogICAgICAgICA4OTAxMjgKICAgICAgPC90ZXh0PgogICAgICA8dGV4dCB4PSIyNTUuMDAiIHk9IjEyLjAwIiB0ZXh0LWFuY2hvcj0ibWlkZGxlIgogICAgICAgICBmb250LWZhbWlseT0iSGVsdmV0aWNhIiBmb250LXNpemU9IjE2LjAwIiBmaWxsPSIjMDAwMDAwIj4KICAgICAgICAgMTIzNDUKICAgICAgPC90ZXh0PgogICA8L2c+Cjwvc3ZnPgo="));
    }
}