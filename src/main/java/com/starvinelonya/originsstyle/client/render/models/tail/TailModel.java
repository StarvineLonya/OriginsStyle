package com.starvinelonya.originsstyle.client.render.models.tail;

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

public class TailModel<T extends AbstractClientPlayerEntity> extends AnimalModel<T> {

    protected ModelPart tail;
    protected ModelPart tail1;
    protected ModelPart tail2;
    protected ModelPart tail3;



    public TailModel(ModelPart root) {
        tail = root.getChild("tail");

    }




    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(tail);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of();
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    public void renderTail(MatrixStack stack, VertexConsumerProvider provider, T entity, BipedEntityModel<T> context, float h, int light, int overlay, Identifier texture) {
        VertexConsumer consumer = provider.getBuffer(RenderLayer.getEntityTranslucent(texture));
        this.tail.copyTransform(context.body);
        this.tail.render(stack, consumer, light, overlay);
    }
    
}
