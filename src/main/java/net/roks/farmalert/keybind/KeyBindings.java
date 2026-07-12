package net.roks.farmalert.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.roks.farmalert.FarmAlert;
import org.lwjgl.glfw.GLFW;

public final class KeyBindings {

    private KeyBindings() {
    }

    public static KeyMapping OPEN_CONFIG;

    public static void register() {

        KeyMapping.Category category =
                KeyMapping.Category.register(
                        FarmAlert.id("keybinds")
                );

        OPEN_CONFIG =
                KeyMappingHelper.registerKeyMapping(
                        new KeyMapping(
                                "key.farmalert.open_config",
                                InputConstants.Type.KEYSYM,
                                GLFW.GLFW_KEY_UNKNOWN,
                                category
                        )
                );
    }
}