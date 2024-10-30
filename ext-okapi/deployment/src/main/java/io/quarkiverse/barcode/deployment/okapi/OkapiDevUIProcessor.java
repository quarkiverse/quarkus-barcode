package io.quarkiverse.barcode.deployment.okapi;

import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.ExternalPageBuilder;
import io.quarkus.devui.spi.page.Page;
import uk.org.okapibarcode.OkapiBarcode;

class OkapiDevUIProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    void createVersion(BuildProducer<CardPageBuildItem> cardPageBuildItemBuildProducer) {
        final CardPageBuildItem card = new CardPageBuildItem();

        final ExternalPageBuilder versionPage = Page.externalPageBuilder("Okapi Version")
                .icon("font-awesome-solid:tag")
                .url("https://github.com/woo-j/OkapiBarcode")
                .doNotEmbed()
                .staticLabel(OkapiBarcode.class.getPackage().getImplementationVersion());

        card.addPage(versionPage);
        card.setCustomCard("qwc-okapi-card.js");
        cardPageBuildItemBuildProducer.produce(card);
    }
}
