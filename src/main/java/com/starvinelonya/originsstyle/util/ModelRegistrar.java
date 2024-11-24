package com.starvinelonya.originsstyle.util;

import com.starvinelonya.originsstyle.OriginsStyle;
import com.starvinelonya.originsstyle.client.render.models.ear.FelineEarModel;
import com.starvinelonya.originsstyle.client.render.models.tail.FelineTailModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModelRegistrar {
    //
    public static final EntityModelLayer FELINE_EARS = new EntityModelLayer(new Identifier(OriginsStyle.MOD_ID, "feline_ears"), "feline_ears");

    //
    public static final EntityModelLayer FELINE_TAIL = new EntityModelLayer(new Identifier(OriginsStyle.MOD_ID, "feline_tail"), "feline_tail");




    public static void registerModels() {
        EntityModelLayerRegistry.registerModelLayer(FELINE_EARS, FelineEarModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(FELINE_TAIL, FelineTailModel::getTexturedModelData);
    }

}
