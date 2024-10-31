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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Path("/zxing")
@ApplicationScoped
public class ZxingResource extends BaseImageResource {

    @GET
    @Path("qr/png")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response qrCodePng() throws IOException, WriterException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // QR Code writer
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // Set error correction level and encoding options
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            int width = 300;
            int height = 300;

            // Generate QR Code as BitMatrix
            BitMatrix bitMatrix = qrCodeWriter.encode("Quarkus Rocks!", BarcodeFormat.QR_CODE, width, height, hints);

            // Generate PNG
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

            // return the image
            return buildImageResponse(outputStream.toByteArray(), PNG_MIME_TYPE, "zxing-code128.png");
        }
    }
}