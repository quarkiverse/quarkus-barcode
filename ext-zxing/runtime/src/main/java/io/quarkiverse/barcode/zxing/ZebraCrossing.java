package io.quarkiverse.barcode.zxing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * The {@code ZebraCrossing} class provides static methods for generating
 * various types of barcodes using the ZXing library. Supported barcode formats
 * include Code 128, Code 39, Code 93, EAN-13, EAN-8, UPC-A, UPC-E, QR Code,
 * and Data Matrix. Each barcode type has two encoding methods:
 * one that uses default encoding hints and another that accepts a custom
 * {@code hints} map to allow for custom encoding parameters.
 *
 * <p>
 * Usage examples:
 * </p>
 *
 * <pre>{@code
 * // Generate a Code 128 barcode with default encoding hints
 * BitMatrix code128Matrix = ZebraCrossing.code128("example", 200, 100);
 * String code128Img = ZebraCrossing.code128Img("example", 200, 100);
 *
 * // Generate a QR Code with custom encoding hints
 * Map<EncodeHintType, Object> hints = Map.of(EncodeHintType.CHARACTER_SET, "UTF-8");
 * BitMatrix qrCodeMatrix = ZebraCrossing.qrCode("example", 200, 200, hints);
 * String qrCodeImg = ZebraCrossing.qrCodeImg("example", 200, 200);
 * }</pre>
 *
 * <p>
 * Each image generation method returns a data URI that can be embedded in
 * HTML for direct display in web applications.
 * </p>
 *
 * <p>
 * For convenience, this class includes helper methods for converting
 * {@code BitMatrix} objects to PNG images and encoding them as base64 data URIs.
 * </p>
 *
 * <p>
 * Note: By default, the character set used for encoding is UTF-8.
 * </p>
 *
 * @see com.google.zxing.Writer
 * @see com.google.zxing.common.BitMatrix
 * @see com.google.zxing.EncodeHintType
 * @see <a href="https://github.com/zxing/zxing">ZXing Project</a>
 */
public class ZebraCrossing {

    private ZebraCrossing() {
        // prevent instantiation
    }

    public static BitMatrix code128(String value, int width, int height) {
        return code128(value, width, height, getHints());
    }

    public static BitMatrix code128(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        Code128Writer writer = new Code128Writer();
        return writer.encode(value, BarcodeFormat.CODE_128, width, height, hints);
    }

    public static String code128Img(String value, int width, int height) {
        return dataUriImg(code128(value, width, height));
    }

    public static BitMatrix code39(String value, int width, int height) {
        return code39(value, width, height, getHints());
    }

    public static BitMatrix code39(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        Code39Writer writer = new Code39Writer();
        return writer.encode(value, BarcodeFormat.CODE_39, width, height, hints);
    }

    public static String code39Img(String value, int width, int height) {
        return dataUriImg(code39(value, width, height));
    }

    public static BitMatrix code93(String value, int width, int height) {
        return code93(value, width, height, getHints());
    }

    public static BitMatrix code93(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        Code93Writer writer = new Code93Writer();
        return writer.encode(value, BarcodeFormat.CODE_93, width, height, hints);
    }

    public static String code93Img(String value, int width, int height) {
        return dataUriImg(code93(value, width, height));
    }

    public static BitMatrix ean13(String value, int width, int height) {
        return ean13(value, width, height, getHints());
    }

    public static BitMatrix ean13(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        EAN13Writer writer = new EAN13Writer();
        return writer.encode(value, BarcodeFormat.EAN_13, width, height, hints);
    }

    public static String ean13Img(String value, int width, int height) {
        return dataUriImg(ean13(value, width, height));
    }

    public static BitMatrix ean8(String value, int width, int height) {
        return ean8(value, width, height, getHints());
    }

    public static BitMatrix ean8(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        EAN8Writer writer = new EAN8Writer();
        return writer.encode(value, BarcodeFormat.EAN_8, width, height, hints);
    }

    public static String ean8Img(String value, int width, int height) {
        return dataUriImg(ean8(value, width, height));
    }

    public static BitMatrix upcA(String value, int width, int height) {
        return upcA(value, width, height, getHints());
    }

    public static BitMatrix upcA(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        UPCAWriter writer = new UPCAWriter();
        return writer.encode(value, BarcodeFormat.UPC_A, width, height, hints);
    }

    public static String upcAImg(String value, int width, int height) {
        return dataUriImg(upcA(value, width, height));
    }

    public static BitMatrix upcE(String value, int width, int height) {
        return upcE(value, width, height, getHints());
    }

    public static BitMatrix upcE(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        UPCEWriter writer = new UPCEWriter();
        return writer.encode(value, BarcodeFormat.UPC_E, width, height, hints);
    }

    public static String upcEImg(String value, int width, int height) {
        return dataUriImg(upcE(value, width, height));
    }

    public static BitMatrix qrCode(String value, int width, int height) {
        return qrCode(value, width, height, getHints());
    }

    public static BitMatrix qrCode(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            return writer.encode(value, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
    }

    public static String qrCodeImg(String value, int width, int height) {
        return dataUriImg(qrCode(value, width, height));
    }

    public static BitMatrix dataMatrix(String value, int width, int height) {
        return dataMatrix(value, width, height, getHints());
    }

    public static BitMatrix dataMatrix(String value, int width, int height, Map<EncodeHintType, ?> hints) {
        DataMatrixWriter writer = new DataMatrixWriter();
        return writer.encode(value, BarcodeFormat.DATA_MATRIX, width, height, hints);
    }

    public static String dataMatrixImg(String value, int width, int height) {
        return dataUriImg(dataMatrix(value, width, height));
    }

    /**
     * Converts a BitMatrix barcode to an HTML img tag with embedded PNG data URI.
     *
     * @param encoded The BitMatrix containing the barcode data
     * @return String containing an HTML img tag with the barcode as a data URI
     */
    public static String dataUriImg(BitMatrix encoded) {
        return dataUriImg(base64ToDataUri(pngToBase64(barcodetoPng(encoded))));
    }

    /**
     * Converts a BitMatrix barcode to a PNG byte array.
     *
     * @param encoded The BitMatrix containing the barcode data
     * @return byte array containing the PNG data
     * @throws RuntimeException if the image cannot be written
     */
    public static byte[] barcodetoPng(BitMatrix encoded) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            MatrixToImageWriter.writeToStream(encoded, "png", out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }

    /**
     * Converts a PNG byte array to a Base64 encoded string.
     *
     * @param png The PNG byte array to convert
     * @return String containing the Base64 encoded PNG data
     */
    public static String pngToBase64(byte[] png) {
        return Base64.getEncoder().encodeToString(png);
    }

    /**
     * Creates a PNG data URI string from Base64 encoded data.
     *
     * @param base64 The Base64 encoded PNG data
     * @return String containing the PNG data URI
     */
    public static String base64ToDataUri(String base64) {
        return "data:image/png;base64," + base64;
    }

    /**
     * Wraps a data URI in an HTML img tag.
     *
     * @param dataUri The data URI to wrap
     * @return String containing an HTML img tag with the data URI as the src
     */
    public static String dataUriImg(String dataUri) {
        return "<img src='" + dataUri + "'/>";
    }

    /**
     * Gets the default encoding hints used for barcode generation.
     * Sets UTF-8 as the default character set.
     *
     * @return Map containing the default encoding hints
     */
    private static Map<EncodeHintType, ?> getHints() {
        return Map.of(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());
    }
}