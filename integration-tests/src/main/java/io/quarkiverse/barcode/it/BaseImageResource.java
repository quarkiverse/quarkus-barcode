package io.quarkiverse.barcode.it;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

public class BaseImageResource {
    public static final String CONTENT_DISPOSITION = "attachment;filename=%s";
    public static final String PNG_MIME_TYPE = "image/png";

    /**
     * Builds a Response containing image data with appropriate headers.
     *
     * @param imageData The raw bytes of the image
     * @param mimeType The MIME type of the image (e.g. "image/png")
     * @param fileName The filename to use in the Content-Disposition header
     * @return A Response object configured with the image data and headers
     */
    protected Response buildImageResponse(byte[] imageData, String mimeType, String fileName) {
        final Response.ResponseBuilder response = Response.ok(imageData);
        response.header(HttpHeaders.CONTENT_DISPOSITION, CONTENT_DISPOSITION.formatted(fileName));
        response.header(HttpHeaders.CONTENT_TYPE, mimeType);
        return response.build();
    }
}
