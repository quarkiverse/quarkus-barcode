package io.quarkiverse.barcode.deployment.zxing;

import java.io.InputStream;
import java.net.URL;
import java.util.jar.Manifest;

import com.google.zxing.BarcodeFormat;

import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.ExternalPageBuilder;
import io.quarkus.devui.spi.page.Page;

/**
 * Zebra Crossing Dev UI.
 */
public class ZebraCrossingDevUIProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    void createVersion(BuildProducer<CardPageBuildItem> cardPageBuildItemBuildProducer) {
        final CardPageBuildItem card = new CardPageBuildItem();

        final ExternalPageBuilder versionPage = Page.externalPageBuilder("ZXing Version")
                .icon("font-awesome-solid:tag")
                .url("https://github.com/zxing/zxing")
                .doNotEmbed()
                .staticLabel(getManifest(BarcodeFormat.class).getMainAttributes().getValue("Bundle-Version"));

        card.addPage(versionPage);
        card.setCustomCard("qwc-zxing-card.js");
        cardPageBuildItemBuildProducer.produce(card);
    }

    public static Manifest getManifest(Class<?> clz) {
        String resource = "/" + clz.getName().replace(".", "/") + ".class";
        String fullPath = clz.getResource(resource).toString();
        String archivePath = fullPath.substring(0, fullPath.lastIndexOf("!") + 1);

        try (InputStream input = new URL(archivePath + "/META-INF/MANIFEST.MF").openStream()) {
            return new Manifest(input);
        } catch (Exception e) {
            throw new RuntimeException("Loading MANIFEST for class " + clz + " failed! " + fullPath, e);
        }
    }
}
