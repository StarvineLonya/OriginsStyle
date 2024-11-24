package com.starvinelonya.originsstyle.client.render.models.ear;

import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;

public class FelineEarModel<T extends AbstractClientPlayerEntity> extends EarModel<T> {


    public FelineEarModel(ModelPart root) {
        super(root);

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        root.addChild("ears", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-4.0F, -3.7F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -3.7F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-3.0F, -3.7F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(-3.0F, -4.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(1.0F, -3.7F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(3.0F, -3.7F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(2.0F, -3.7F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(2.0F, -4.7F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)),
                ModelTransform.NONE);
        return TexturedModelData.of(modelData, 16, 16);
    }

}
