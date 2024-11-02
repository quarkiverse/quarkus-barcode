package io.quarkiverse.barcode.okapi;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.imageio.ImageIO;

import uk.org.okapibarcode.backend.Code128;
import uk.org.okapibarcode.backend.Code3Of9;
import uk.org.okapibarcode.backend.Code93;
import uk.org.okapibarcode.backend.DataMatrix;
import uk.org.okapibarcode.backend.Ean;
import uk.org.okapibarcode.backend.QrCode;
import uk.org.okapibarcode.backend.Symbol;
import uk.org.okapibarcode.backend.Upc;
import uk.org.okapibarcode.graphics.Color;
import uk.org.okapibarcode.output.Java2DRenderer;
import uk.org.okapibarcode.output.PostScriptRenderer;
import uk.org.okapibarcode.output.SvgRenderer;

/**
 * Utility class for generating various barcode formats as PNG or SVG images.
 * <p>
 * This class provides methods to create barcodes in popular formats such as
 * Code128, Code39, Code93, EAN-13, EAN-8, UPC-A, QR Code, and Data Matrix.
 * Each barcode type can be generated as a {@link BufferedImage} (for PNG)
 * or as a data URI string (in either PNG or SVG formats) that can be
 * directly embedded into HTML or other documents.
 * </p>
 * <p>
 * Example usage:
 *
 * <pre>{@code
 * // Generate a PNG BufferedImage for a Code128 barcode
 * BufferedImage image = Okapi.code128("1234567890", 200, 100);
 *
 * // Generate a data URI for embedding a Code39 barcode in SVG format
 * String svgDataUri = Okapi.code39Svg("12345", 1.0);
 * }</pre>
 * </p>
 * <p>
 * All methods are static, and this class is not intended to be instantiated.
 * The methods are designed for easy generation of barcode images with adjustable
 * dimensions (for PNG) or magnification (for SVG) to suit various rendering contexts.
 * </p>
 *
 * <p>
 * <strong>Supported barcode formats:</strong>
 * </p>
 * <ul>
 * <li>Code128</li>
 * <li>Code39</li>
 * <li>Code93</li>
 * <li>EAN-13</li>
 * <li>EAN-8</li>
 * <li>UPC-A</li>
 * <li>QR Code</li>
 * <li>Data Matrix</li>
 * </ul>
 *
 * <p>
 * <strong>Supported image outputs:</strong>
 * </p>
 * <ul>
 * <li>PNG - rendered as a {@link BufferedImage}</li>
 * <li>SVG - rendered as a Base64-encoded data URI string</li>
 * </ul>
 *
 * <p>
 * All SVG generation methods offer an optional magnification parameter to scale
 * the output image, making it easy to produce barcodes suitable for a wide range
 * of display sizes and resolutions.
 * </p>
 *
 * <p>
 * <strong>Note:</strong> PNG generation relies on the {@link Java2DRenderer}
 * and requires setting appropriate image dimensions for accurate rendering.
 * SVG output uses {@link SvgRenderer} and supports magnification scaling.
 * </p>
 *
 * @see Code128
 * @see Code3Of9
 * @see Ean
 * @see SvgRenderer
 * @see Java2DRenderer
 */
public class Okapi {

    private Okapi() {
        // prevent instantiation
    }

    public static BufferedImage code128(String value, int width, int height) {
        Code128 code128 = new Code128();
        code128.setContent(value);
        return generateBarcodePng(code128, width, height);
    }

    public static String code128Png(String value, int width, int height) {
        return dataUriPng(code128(value, width, height));
    }

    public static String code128Svg(String value, double magnification) {
        Code128 code128 = new Code128();
        code128.setContent(value);
        return dataUriSvg(generateBarcodeSvg(code128, magnification));
    }

    public static BufferedImage code39(String value, int width, int height) {
        Code3Of9 code39 = new Code3Of9();
        code39.setContent(value);
        return generateBarcodePng(code39, width, height);
    }

    public static String code39Png(String value, int width, int height) {
        return dataUriPng(code39(value, width, height));
    }

    public static String code39Svg(String value, double magnification) {
        Code3Of9 code39 = new Code3Of9();
        code39.setContent(value);
        return dataUriSvg(generateBarcodeSvg(code39, magnification));
    }

    public static BufferedImage code93(String value, int width, int height) {
        Code93 code93 = new Code93();
        code93.setContent(value);
        return generateBarcodePng(code93, width, height);
    }

    public static String code93Png(String value, int width, int height) {
        return dataUriPng(code93(value, width, height));
    }

    public static String code93Svg(String value, double magnification) {
        Code93 code93 = new Code93();
        code93.setContent(value);
        return dataUriSvg(generateBarcodeSvg(code93, magnification));
    }

    public static BufferedImage ean13(String value, int width, int height) {
        Ean ean13 = new Ean(Ean.Mode.EAN13);
        ean13.setContent(value);
        return generateBarcodePng(ean13, width, height);
    }

    public static String ean13Png(String value, int width, int height) {
        return dataUriPng(ean13(value, width, height));
    }

    public static String ean13Svg(String value, double magnification) {
        Ean ean13 = new Ean(Ean.Mode.EAN13);
        ean13.setContent(value);
        return dataUriSvg(generateBarcodeSvg(ean13, magnification));
    }

    public static BufferedImage ean8(String value, int width, int height) {
        Ean ean8 = new Ean(Ean.Mode.EAN8);
        ean8.setContent(value);
        return generateBarcodePng(ean8, width, height);
    }

    public static String ean8Png(String value, int width, int height) {
        return dataUriPng(ean8(value, width, height));
    }

    public static String ean8Svg(String value, double magnification) {
        Ean ean8 = new Ean(Ean.Mode.EAN8);
        ean8.setContent(value);
        return dataUriSvg(generateBarcodeSvg(ean8, magnification));
    }

    public static BufferedImage upcA(String value, int width, int height) {
        Upc upcA = new Upc(Upc.Mode.UPCA);
        upcA.setContent(value);
        return generateBarcodePng(upcA, width, height);
    }

    public static String upcAPng(String value, int width, int height) {
        return dataUriPng(upcA(value, width, height));
    }

    public static String upcASvg(String value, double magnification) {
        Upc upcA = new Upc(Upc.Mode.UPCA);
        upcA.setContent(value);
        return dataUriSvg(generateBarcodeSvg(upcA, magnification));
    }

    public static BufferedImage qrCode(String value, int width, int height) {
        QrCode qrCode = new QrCode();
        qrCode.setContent(value);
        return generateBarcodePng(qrCode, width, height);
    }

    public static String qrCodePng(String value, int width, int height) {
        return dataUriPng(qrCode(value, width, height));
    }

    public static String qrCodeSvg(String value, double magnification) {
        QrCode qrCode = new QrCode();
        qrCode.setContent(value);
        return dataUriSvg(generateBarcodeSvg(qrCode, magnification));
    }

    public static BufferedImage dataMatrix(String value, int width, int height) {
        DataMatrix dataMatrix = new DataMatrix();
        dataMatrix.setContent(value);
        return generateBarcodePng(dataMatrix, width, height);
    }

    public static String dataMatrixPng(String value, int width, int height) {
        return dataUriPng(dataMatrix(value, width, height));
    }

    public static String dataMatrixSvg(String value, double magnification) {
        DataMatrix dataMatrix = new DataMatrix();
        dataMatrix.setContent(value);
        return dataUriSvg(generateBarcodeSvg(dataMatrix, magnification));
    }

    /**
     * Generates an SVG barcode as a String with default magnification of 1.0.
     *
     * @param symbol The barcode symbol to render
     * @return String containing the SVG barcode
     */
    public static String generateBarcodeSvgAsString(Symbol symbol) {
        return new String(generateBarcodeSvg(symbol, 1.0), StandardCharsets.UTF_8);
    }

    /**
     * Generates an SVG barcode as a byte array with default magnification of 1.0.
     *
     * @param symbol The barcode symbol to render
     * @return byte array containing the SVG barcode
     */
    public static byte[] generateBarcodeSvg(Symbol symbol) {
        return generateBarcodeSvg(symbol, 1.0);
    }

    /**
     * Generates an SVG barcode as a byte array with specified magnification.
     *
     * @param symbol The barcode symbol to render
     * @param magnification The magnification factor to apply
     * @return byte array containing the SVG barcode
     */
    public static byte[] generateBarcodeSvg(Symbol symbol, double magnification) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        SvgRenderer renderer = new SvgRenderer(out, magnification, Color.WHITE, Color.BLACK, true);
        try {
            renderer.render(symbol);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }

    /**
     * Generates an EPS Postscript barcode as a String with default magnification of 1.0.
     *
     * @param symbol The barcode symbol to render
     * @return String containing the EPS Postscript barcode
     */
    public static String generateBarcodePostscriptAsString(Symbol symbol) {
        return new String(generateBarcodePostscript(symbol, 1.0), StandardCharsets.UTF_8);
    }

    /**
     * Generates an EPS Postscript barcode as a byte array with specified magnification.
     *
     * @param symbol The barcode symbol to render
     * @param magnification The magnification factor to apply
     * @return byte array containing the EPS Postscript barcode
     */
    public static byte[] generateBarcodePostscript(Symbol symbol, double magnification) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PostScriptRenderer renderer = new PostScriptRenderer(out, magnification, Color.WHITE, Color.BLACK);
        try {
            renderer.render(symbol);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }

    /**
     * Generates a PNG barcode as a BufferedImage with default magnification of 1.0.
     *
     * @param symbol The barcode symbol to render
     * @param width The desired width of the image
     * @param height The desired height of the image
     * @return BufferedImage containing the PNG barcode
     */
    public static BufferedImage generateBarcodePng(Symbol symbol, int width, int height) {
        return generateBarcodePng(symbol, width, height, 1.0);
    }

    /**
     * Generates a PNG barcode as a BufferedImage with specified magnification.
     *
     * @param symbol The barcode symbol to render
     * @param width The desired width of the image
     * @param height The desired height of the image
     * @param magnification The magnification factor to apply
     * @return BufferedImage containing the PNG barcode
     */
    public static BufferedImage generateBarcodePng(Symbol symbol, int width, int height, double magnification) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = image.createGraphics();
        Java2DRenderer renderer = new Java2DRenderer(g2d, magnification, Color.WHITE, Color.BLACK);
        renderer.render(symbol);
        g2d.dispose();
        return image;
    }

    /**
     * Converts a BufferedImage to a data URI string in PNG format.
     *
     * @param image The BufferedImage to convert
     * @return String containing the data URI
     */
    public static String dataUriPng(BufferedImage image) {
        return base64ToDataUri(pngToBase64(image), "image/png");
    }

    /**
     * Converts a byte array to a data URI string in SVG format.
     *
     * @param bytes The byte array containing SVG data
     * @return String containing the data URI
     */
    public static String dataUriSvg(byte[] bytes) {
        final String base64 = bytesToBase64(bytes);
        return base64ToDataUri(base64, "image/svg+xml");
    }

    /**
     * Converts a BufferedImage to a PNG byte array.
     *
     * @param image The BufferedImage to convert
     * @return byte array containing the PNG data
     * @throws RuntimeException if the image cannot be written
     */
    public static byte[] pngToBytes(BufferedImage image) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }

    /**
     * Converts a BufferedImage to a Base64 encoded PNG string.
     *
     * @param image The BufferedImage to convert
     * @return String containing the Base64 encoded PNG data
     */
    public static String pngToBase64(BufferedImage image) {
        return bytesToBase64(new String(pngToBytes(image), StandardCharsets.UTF_8).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Converts a byte array to a Base64 encoded string.
     *
     * @param bytes The byte array to convert
     * @return String containing the Base64 encoded data
     */
    public static String bytesToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Creates a data URI string from Base64 encoded data and MIME type.
     *
     * @param base64 The Base64 encoded data
     * @param mimeType The MIME type of the data
     * @return String containing the data URI
     */
    public static String base64ToDataUri(String base64, String mimeType) {
        return "data:%s;base64,%s".formatted(mimeType, base64);
    }

}