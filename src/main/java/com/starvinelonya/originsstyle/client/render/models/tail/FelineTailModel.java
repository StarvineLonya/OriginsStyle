package com.starvinelonya.originsstyle.client.render.models.tail;

import com.starvinelonya.originsstyle.OriginsStyle;
import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import static java.lang.Math.abs;
import static java.lang.Math.cos;

public class FelineTailModel<T extends AbstractClientPlayerEntity> extends TailModel<T> {
    public FelineTailModel(ModelPart root) {
        super(root);
        tail1 = tail.getChild("tail1");
        tail2 = tail1.getChild("tail2");
        tail3 = tail2.getChild("tail3");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData tail = root.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0F, 2.5F, -0.0F));
        ModelPartData tail1 = tail.addChild("tail1", ModelPartBuilder.create().uv(4, 0).cuboid(-0.5F, 0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0F, 2.5f, -0.0F));
        ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(8, 0).cuboid(-0.5F, -0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0F, 2.5F, -0.0F));
        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(12, 0).cuboid(-0.5F, -0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0F, 2.5F, -0.0F));

        return TexturedModelData.of(modelData, 16, 16);
    }

    private void idlePose(float animationProgress) {

        float tailAngle = (float) cos(animationProgress * 0.05f);
        tail.pitch = tail1.pitch = tail2.pitch = tail3.pitch = tailAngle * 0.1f;
        tail.roll = tailAngle * 0.1f;
        tail1.roll = tail.roll;
        tail2.roll = tail1.roll;
        tail3.roll = tail2.roll;

    }
    private void runPose(float animationProgress) {
        float tailAngle = (float) cos(animationProgress * 0.2f);
        tail.pitch = tail1.pitch = tail2.pitch = tail3.pitch = tailAngle * 0.1f + 0.5f;
        tail.roll = tailAngle * 0.3f;
        tail1.roll = tail.roll;
        tail2.roll = tail1.roll;
        tail3.roll = tail2.roll;
    }
    public void updatePose(BipedEntityModel<T> context, T entity, float animationProgress){
        context.copyStateTo(this);
        if (entity.isSprinting()) {
            runPose(animationProgress);
        }else{
            idlePose(animationProgress);
        }
    }


    @Override
    public void renderTail(MatrixStack stack, VertexConsumerProvider provider, T entity, BipedEntityModel<T> context, float h, int light, int overlay, Identifier texture) {
        stack.translate(0.0, 0.65, 0.1);
        stack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(120));

        super.renderTail(stack, provider, entity, context, h, light, overlay, texture);
    }
}
