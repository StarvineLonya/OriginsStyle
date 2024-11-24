package com.starvinelonya.originsstyle.client.render.models.ear;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class EarModel<T extends AbstractClientPlayerEntity> extends AnimalModel<T> {

    protected ModelPart ears;



    public EarModel(ModelPart root) {
        ears = root.getChild("ears");
    }


    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(ears);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of();
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.ears.pitch = entity.getPitch();
        this.ears.yaw = entity.getHeadYaw();
    }

    public void renderEars(MatrixStack stack, VertexConsumerProvider provider, T entity, BipedEntityModel<T> context, float h, int light, int overlay, Identifier texture) {
        VertexConsumer consumer = provider.getBuffer(RenderLayer.getEntityTranslucent(texture));
        float o = MathHelper.lerp(h, entity.prevYaw, entity.getYaw()) - MathHelper.lerp(h, entity.prevBodyYaw, entity.bodyYaw);
        float p = MathHelper.lerp(h, entity.prevPitch, entity.getPitch());
        stack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(o));
        stack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(p));
        stack.translate(0.0F, -0.375F, 0.0F);
        stack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-p));
        stack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-o));
        this.ears.copyTransform(context.head);
        this.ears.pivotX = 0.0F;
        this.ears.pivotY = 0.0F;
        this.ears.render(stack, consumer, light, overlay);
    }
    
}
