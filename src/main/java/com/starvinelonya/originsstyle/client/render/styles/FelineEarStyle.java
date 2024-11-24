package com.starvinelonya.originsstyle.client.render.styles;

import net.minecraft.util.Identifier;

public class FelineEarStyle {

    public static final Identifier DEFAULT_TEXTURE = new Identifier("originsstyle:textures/ears/feline_ears_black.png");
    private final Identifier texture;

    public FelineEarStyle(Identifier texture) {
        this.texture = texture;
    }

    public Identifier getTexture() {
        return texture;
    }
}
