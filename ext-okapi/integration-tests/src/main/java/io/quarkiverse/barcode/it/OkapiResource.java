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

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import uk.org.okapibarcode.backend.Code128;
import uk.org.okapibarcode.backend.HumanReadableLocation;
import uk.org.okapibarcode.graphics.Color;
import uk.org.okapibarcode.output.Java2DRenderer;
import uk.org.okapibarcode.output.SvgRenderer;

@Path("/okapi")
@ApplicationScoped
public class OkapiResource extends BaseImageResource {

    @GET
    @Path("code128/png")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response code128() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Code128 barcode = createCode128();

            int width = barcode.getWidth();
            int height = barcode.getHeight();

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g2d = image.createGraphics();
            Java2DRenderer renderer = new Java2DRenderer(g2d, 1, Color.WHITE, Color.BLACK);
            renderer.render(barcode);
            g2d.dispose();

            ImageIO.write(image, "png", outputStream);

            // return the image
            return buildImageResponse(outputStream.toByteArray(), PNG_MIME_TYPE, "okapi-code128.png");
        }
    }

    @GET
    @Path("code128/svg")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response code128Svg() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Code128 barcode = createCode128();
            SvgRenderer renderer = new SvgRenderer(outputStream, 1, Color.WHITE, Color.BLACK, true);
            renderer.render(barcode);
            String svg = stripWhitespace(outputStream.toString());
            return buildImageResponse(svg.getBytes(StandardCharsets.UTF_8), SVG_MIME_TYPE, "okapi-code128.svg");
        }
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