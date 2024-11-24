package com.starvinelonya.originsstyle.client.render.renderers;

import com.starvinelonya.originsstyle.client.render.models.tail.FelineTailModel;
import com.starvinelonya.originsstyle.client.render.styles.FelineTailStyle;
import com.starvinelonya.originsstyle.util.ModelRegistrar;
import com.starvinelonya.originsstyle.util.OriginUtil;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;

public class TailFeatureRenderer<T extends AbstractClientPlayerEntity, M extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {

    private final FelineTailModel<T> felineTailModel;
    public TailFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.felineTailModel = new FelineTailModel<>(loader.getModelPart(ModelRegistrar.FELINE_TAIL));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if(OriginUtil.shouldRenderTail(entity)) {
            this.felineTailModel.animateModel(entity, limbAngle, limbDistance, tickDelta);
            this.felineTailModel.updatePose(this.getContextModel(), entity, animationProgress);
            this.felineTailModel.renderTail(matrices, vertexConsumers, entity, this.getContextModel(), limbAngle, light, 0, FelineTailStyle.DEFAULT_TEXTURE);
        }
    }
}
