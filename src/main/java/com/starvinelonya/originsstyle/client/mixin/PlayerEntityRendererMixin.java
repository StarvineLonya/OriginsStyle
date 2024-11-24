package com.starvinelonya.originsstyle.client.mixin;

import com.starvinelonya.originsstyle.client.render.models.ear.FelineEarModel;
import com.starvinelonya.originsstyle.client.render.renderers.EarFeatureRenderer;
import com.starvinelonya.originsstyle.client.render.renderers.TailFeatureRenderer;
import com.starvinelonya.originsstyle.util.OriginUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> implements LivingEntityFeatureRendererRegistrationCallback {
    @Shadow public abstract Vec3d getPositionOffset(AbstractClientPlayerEntity abstractClientPlayerEntity, float f);

    public PlayerEntityRendererMixin(EntityRendererFactory.Context context, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }
    @Inject(method = "<init>(Lnet/minecraft/client/render/entity/EntityRendererFactory$Context;Z)V", at = @At("TAIL"))
    public void onConstructor(EntityRendererFactory.Context context, boolean slim, CallbackInfo info) {
        this.addFeature(new EarFeatureRenderer<>(this, context.getModelLoader()));
        this.addFeature(new TailFeatureRenderer<>(this, context.getModelLoader()));
    }

    @Inject(method = "setModelPose", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;isInSneakingPose()Z", shift = At.Shift.AFTER))
    public void onSetModelPose(AbstractClientPlayerEntity player, CallbackInfo info) {
        if (OriginUtil.shouldRenderEars(player)) {
            this.getModel().body.visible = true;
        }
    }
}
