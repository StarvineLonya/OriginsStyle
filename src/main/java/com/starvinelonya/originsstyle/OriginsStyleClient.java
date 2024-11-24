package com.starvinelonya.originsstyle;

import com.starvinelonya.originsstyle.util.ModelRegistrar;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class OriginsStyleClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelRegistrar.registerModels();
    }
}
