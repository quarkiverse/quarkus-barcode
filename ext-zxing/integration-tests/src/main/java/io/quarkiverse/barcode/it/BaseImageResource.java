package io.quarkiverse.barcode.it;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

public class BaseImageResource {
    public static final String CONTENT_DISPOSITION = "attachment;filename=%s";
    public static final String PNG_MIME_TYPE = "image/png";
    public static final String SVG_MIME_TYPE = "image/svg+xml";

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

    protected String stripWhitespace(String svgContent) {
        // Remove unnecessary whitespace characters (spaces, tabs, newlines) from SVG content
        return svgContent
                .replaceAll(">\\s+<", "><") // Remove whitespace between tags
                .replaceAll("\\s{2,}", " ") // Replace multiple spaces with a single space
                .replaceAll("\\s+/>", "/>"); // Trim spaces before self-closing tags
    }
}