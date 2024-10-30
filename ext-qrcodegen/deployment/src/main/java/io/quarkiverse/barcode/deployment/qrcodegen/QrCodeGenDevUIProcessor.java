package io.quarkiverse.barcode.deployment.qrcodegen;

import java.util.Objects;

import io.nayuki.qrcodegen.QrCode;
import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.ExternalPageBuilder;
import io.quarkus.devui.spi.page.Page;

/**
 * QR Code Generator Dev UI.
 */
class QrCodeGenDevUIProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    void createVersion(BuildProducer<CardPageBuildItem> cardPageBuildItemBuildProducer) {
        final CardPageBuildItem card = new CardPageBuildItem();

        final ExternalPageBuilder versionPage = Page.externalPageBuilder("QR Code Generator Version")
                .icon("font-awesome-solid:tag")
                .url("https://github.com/nayuki/QR-Code-generator")
                .doNotEmbed()
                .staticLabel(
                        Objects.toString(QrCode.class.getPackage().getImplementationVersion(), "1.8.0"));

        card.addPage(versionPage);
        card.setCustomCard("qwc-qrcodegen-card.js");
        cardPageBuildItemBuildProducer.produce(card);
    }
}
