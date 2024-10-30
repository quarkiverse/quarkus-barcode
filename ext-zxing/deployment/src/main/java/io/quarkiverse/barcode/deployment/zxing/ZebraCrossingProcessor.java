package io.quarkiverse.barcode.deployment.zxing;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.IndexDependencyBuildItem;

class ZebraCrossingProcessor {

    private static final String FEATURE = "zxing";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    void indexTransitiveDependencies(BuildProducer<IndexDependencyBuildItem> index) {
        index.produce(new IndexDependencyBuildItem("com.google.zxing", "core"));
        index.produce(new IndexDependencyBuildItem("com.google.zxing", "javase"));
    }

}
