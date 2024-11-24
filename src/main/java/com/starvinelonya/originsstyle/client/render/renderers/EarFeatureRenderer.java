package com.starvinelonya.originsstyle.client.render.renderers;

import com.starvinelonya.originsstyle.client.render.models.ear.FelineEarModel;
import com.starvinelonya.originsstyle.client.render.styles.FelineEarStyle;
import com.starvinelonya.originsstyle.util.ModelRegistrar;
import com.starvinelonya.originsstyle.util.OriginUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class EarFeatureRenderer<T extends AbstractClientPlayerEntity, M extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {
    private final FelineEarModel<T> felineEarModel;
    public EarFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.felineEarModel = new FelineEarModel<>(loader.getModelPart(ModelRegistrar.FELINE_EARS));
    }


    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexes, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {

        if (OriginUtil.shouldRenderEars(entity)) {
            matrices.push();
            if (true) {
                this.felineEarModel.renderEars(matrices, vertexes, entity, this.getContextModel(), tickDelta, light, OverlayTexture.DEFAULT_UV, FelineEarStyle.DEFAULT_TEXTURE);
            }
            matrices.pop();
        }
    }
}
