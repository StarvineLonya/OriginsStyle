package com.starvinelonya.originsstyle.client.render.styles;

import net.minecraft.util.Identifier;

public class FelineTailStyle {
    public static final Identifier DEFAULT_TEXTURE = new Identifier("originsstyle:textures/tails/feline_tail_black.png");
    private final Identifier texture;

    public FelineTailStyle(Identifier texture) {
        this.texture = texture;
    }

    public Identifier getTexture() {
        return texture;
    }
}