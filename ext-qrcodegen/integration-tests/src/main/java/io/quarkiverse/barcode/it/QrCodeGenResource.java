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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

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

import io.nayuki.qrcodegen.QrCode;

@Path("/qrcodegen")
@ApplicationScoped
public class QrCodeGenResource extends BaseImageResource {

    @GET
    @Path("qr/png")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response qrCodePng() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            QrCode qr = QrCode.encodeText("Quarkus Rocks!", QrCode.Ecc.MEDIUM);
            BufferedImage img = toImage(qr, 4, 10, 0xFFE0E0, 0x602020);
            ImageIO.write(img, "png", outputStream);

            // return the image
            return buildImageResponse(outputStream.toByteArray(), PNG_MIME_TYPE, "qrcodegen.png");
        }
    }

    @GET
    @Path("qr/svg")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response qrCodeSvg() {
        QrCode qr = QrCode.encodeText("Quarkus Rocks!", QrCode.Ecc.MEDIUM);
        String svg = stripWhitespace(toSvgString(qr, 4, "#FFFFFF", "#000000")); // Convert to SVG XML code

        // return the image
        return buildImageResponse(svg.getBytes(StandardCharsets.UTF_8), SVG_MIME_TYPE, "qrcodegen.svg");
    }

    /**
     * Returns a raster image depicting the specified QR Code, with
     * the specified module scale, border modules, and module colors.
     * <p>
     * For example, scale=10 and border=4 means to pad the QR Code with 4 light border
     * modules on all four sides, and use 10&#xD7;10 pixels to represent each module.
     *
     * @param qr the QR Code to render (not {@code null})
     * @param scale the side length (measured in pixels, must be positive) of each module
     * @param border the number of border modules to add, which must be non-negative
     * @param lightColor the color to use for light modules, in 0xRRGGBB format
     * @param darkColor the color to use for dark modules, in 0xRRGGBB format
     * @return a new image representing the QR Code, with padding and scaling
     * @throws NullPointerException if the QR Code is {@code null}
     * @throws IllegalArgumentException if the scale or border is out of range, or if
     *         {scale, border, size} cause the image dimensions to exceed Integer.MAX_VALUE
     */
    private static BufferedImage toImage(QrCode qr, int scale, int border, int lightColor, int darkColor) {
        Objects.requireNonNull(qr);
        if (scale <= 0 || border < 0)
            throw new IllegalArgumentException("Value out of range");
        if (border > Integer.MAX_VALUE / 2 || qr.size + border * 2L > Integer.MAX_VALUE / scale)
            throw new IllegalArgumentException("Scale or border too large");

        BufferedImage result = new BufferedImage((qr.size + border * 2) * scale, (qr.size + border * 2) * scale,
                BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                boolean color = qr.getModule(x / scale - border, y / scale - border);
                result.setRGB(x, y, color ? darkColor : lightColor);
            }
        }
        return result;
    }

    /**
     * Returns a string of SVG code for an image depicting the specified QR Code, with the specified
     * number of border modules. The string always uses Unix newlines (\n), regardless of the platform.
     *
     * @param qr the QR Code to render (not {@code null})
     * @param border the number of border modules to add, which must be non-negative
     * @param lightColor the color to use for light modules, in any format supported by CSS, not {@code null}
     * @param darkColor the color to use for dark modules, in any format supported by CSS, not {@code null}
     * @return a string representing the QR Code as an SVG XML document
     * @throws NullPointerException if any object is {@code null}
     * @throws IllegalArgumentException if the border is negative
     */
    private static String toSvgString(QrCode qr, int border, String lightColor, String darkColor) {
        Objects.requireNonNull(qr);
        Objects.requireNonNull(lightColor);
        Objects.requireNonNull(darkColor);
        if (border < 0)
            throw new IllegalArgumentException("Border must be non-negative");
        StringBuilder sb = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
                .append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n")
                .append(String.format(
                        "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" viewBox=\"0 0 %1$d %1$d\" stroke=\"none\">\n",
                        qr.size + (long) border * 2))
                .append("\t<rect width=\"100%\" height=\"100%\" fill=\"").append(lightColor).append("\"/>\n")
                .append("\t<path d=\"");
        for (int y = 0; y < qr.size; y++) {
            for (int x = 0; x < qr.size; x++) {
                if (qr.getModule(x, y)) {
                    if (x != 0 || y != 0)
                        sb.append(" ");
                    sb.append(String.format("M%d,%dh1v1h-1z", x + (long) border, y + (long) border));
                }
            }
        }
        return sb.append("\" fill=\"").append(darkColor).append("\"/>\n")
                .append("</svg>\n")
                .toString();
    }
}
