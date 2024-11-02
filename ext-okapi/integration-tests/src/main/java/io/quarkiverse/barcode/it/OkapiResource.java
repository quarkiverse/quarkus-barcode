/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package io.quarkiverse.barcode.it;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import io.quarkiverse.barcode.okapi.Okapi;
import uk.org.okapibarcode.backend.Code128;
import uk.org.okapibarcode.backend.HumanReadableLocation;

@Path("/okapi")
@ApplicationScoped
public class OkapiResource extends BaseImageResource {

    @GET
    @Path("code128/png")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response code128() throws IOException {
        Code128 barcode = createCode128();

        int width = barcode.getWidth();
        int height = barcode.getHeight();

        BufferedImage image = Okapi.generateBarcodePng(barcode, width, height);
        byte[] bytes = Okapi.pngToBytes(image);
        // return the image
        return buildImageResponse(bytes, PNG_MIME_TYPE, "okapi-code128.png");
    }

    @GET
    @Path("code128/svg")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response code128Svg() throws IOException {
        Code128 barcode = createCode128();
        String svg = stripWhitespace(Okapi.generateBarcodeSvgAsString(barcode));
        return buildImageResponse(svg.getBytes(StandardCharsets.UTF_8), SVG_MIME_TYPE, "okapi-code128.svg");
    }

    @GET
    @Path("code128/eps")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response code128Postscript() throws IOException {
        Code128 barcode = createCode128();
        String eps = stripWhitespace(Okapi.generateBarcodePostscriptAsString(barcode));
        return buildImageResponse(eps.getBytes(StandardCharsets.UTF_8), POSTSCRIPT_MIME_TYPE, "okapi-code128.eps");
    }

    @GET
    @Path("ean13/png/base64")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response ean13PngBase64() throws IOException {
        String image = Okapi.ean13Png("123456789012+12345", 300, 300);
        return buildImageResponse(image, PNG_MIME_TYPE, "okapi-ean13.png");
    }

    @GET
    @Path("ean13/svg/base64")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response ean13SvgBase64() throws IOException {
        String image = Okapi.ean13Svg("123456789012+12345", 2.0);
        return buildImageResponse(image, SVG_MIME_TYPE, "okapi-ean13.svg");
    }

    private Code128 createCode128() {
        Code128 barcode = new Code128();
        barcode.setFontName("Monospaced");
        barcode.setFontSize(16);
        barcode.setModuleWidth(2);
        barcode.setBarHeight(50);
        barcode.setHumanReadableLocation(HumanReadableLocation.BOTTOM);
        barcode.setContent("123456789");
        return barcode;
    }
}