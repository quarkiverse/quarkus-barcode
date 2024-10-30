package io.quarkiverse.barcode.deployment.barcode4j;

import org.krysalis.barcode4j.BarcodeGenerator;

import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.ExternalPageBuilder;
import io.quarkus.devui.spi.page.Page;

/**
 * Barcode4J Dev UI.
 */
class Barcode4JDevUIProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    void createVersion(BuildProducer<CardPageBuildItem> cardPageBuildItemBuildProducer) {
        final CardPageBuildItem card = new CardPageBuildItem();

        final ExternalPageBuilder versionPage = Page.externalPageBuilder("Barcode4J Version")
                .icon("font-awesome-solid:tag")
                .url("https://barcode4j.sourceforge.net/")
                .doNotEmbed()
                .staticLabel(BarcodeGenerator.class.getPackage().getImplementationVersion());

        card.addPage(versionPage);
        card.setCustomCard("qwc-barcode4j-card.js");
        cardPageBuildItemBuildProducer.produce(card);
    }
}
