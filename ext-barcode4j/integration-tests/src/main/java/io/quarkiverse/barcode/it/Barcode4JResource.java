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

import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.BarcodeCanvasSetupException;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.output.svg.SVGCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.w3c.dom.DocumentFragment;

@Path("/barcode4j")
@ApplicationScoped
public class Barcode4JResource extends BaseImageResource {

    private static final int DPI = 150;

    @GET
    @Path("code39/png")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response code39Png() throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            //Create the barcode bean
            final Code39Bean bean = createCode39Bean();

            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    outputStream, PNG_MIME_TYPE, DPI, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            //Generate the barcode
            bean.generateBarcode(canvas, "Quarkus Rocks");

            //Signal end of generation
            canvas.finish();

            // return the image
            return buildImageResponse(outputStream.toByteArray(), PNG_MIME_TYPE, "barcode4j-code39.png");
        }
    }

    @GET
    @Path("code39/svg")
    @APIResponse(responseCode = "200", description = "Document downloaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = SchemaType.STRING, format = "binary")))
    public Response code39Svg() throws IOException, BarcodeCanvasSetupException, TransformerException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            //Create the barcode bean
            final Code39Bean bean = createCode39Bean();

            SVGCanvasProvider canvas = new SVGCanvasProvider(false, 0);

            //Generate the barcode
            bean.generateBarcode(canvas, "Quarkus Rocks");

            DocumentFragment frag = canvas.getDOMFragment();
            TransformerFactory factory = TransformerFactory.newInstance();
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            Transformer trans = factory.newTransformer();
            Source src = new javax.xml.transform.dom.DOMSource(frag);
            Result res = new javax.xml.transform.stream.StreamResult(outputStream);
            trans.transform(src, res);

            // return the image
            return buildImageResponse(outputStream.toByteArray(), SVG_MIME_TYPE, "barcode4j-code39.svg");
        }
    }

    private Code39Bean createCode39Bean() {
        final Code39Bean bean = new Code39Bean();
        bean.setModuleWidth(UnitConv.in2mm(1.0f / DPI)); //makes the narrow bar, width exactly one pixel
        bean.setWideFactor(3);
        bean.doQuietZone(false);
        return bean;
    }
}
