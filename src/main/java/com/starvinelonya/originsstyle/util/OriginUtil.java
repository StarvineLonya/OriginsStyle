package com.starvinelonya.originsstyle.util;


import com.starvinelonya.originsstyle.OriginsStyle;
import com.starvinelonya.originsstyle.client.render.styles.FelineEarStyle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.NbtPredicate;

public class OriginUtil {
    public static String getOriginType(Entity entity) {
        NbtCompound nbt = NbtPredicate.entityToNbt(entity);
        return nbt.getCompound("cardinal_components").getCompound("origins:origin").getList("OriginLayers", 10).getCompound(0).getString("Origin");
    }
    public static boolean isOriginType(Entity entity, String origin) {
        return getOriginType(entity).equals(origin);
    }

    public static boolean isOriginTypeIn(Entity entity, String[] origins) {
        for (String origin : origins) {
            if (isOriginType(entity, origin)) {
                return true;
            }
        }
        return false;
    }

    public static boolean shouldRenderEars(PlayerEntity entity) {
        return isOriginTypeIn(entity, OriginTypes.earedOrigins);
    }
    public static boolean shouldRenderTail(PlayerEntity entity) {
        return isOriginTypeIn(entity, OriginTypes.tailedOrigins);
    }

    public static FelineEarStyle getFelineEarStyle(PlayerEntity entity){
        if (isOriginType(entity, "origins:human")){
            OriginsStyle.LOGGER.info("1");
            return new FelineEarStyle(FelineEarStyle.DEFAULT_TEXTURE);
        } else if (isOriginType(entity, "")) {
            return null;
        }
        return new FelineEarStyle(FelineEarStyle.DEFAULT_TEXTURE);
    }

}
