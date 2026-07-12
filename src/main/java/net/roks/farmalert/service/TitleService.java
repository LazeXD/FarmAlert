package net.roks.farmalert.service;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public final class TitleService {

    private static final int DEFAULT_FADE_IN = 5;
    private static final int DEFAULT_STAY = 40;
    private static final int DEFAULT_FADE_OUT = 10;

    private TitleService() {
    }

    public static void show(Minecraft minecraft,
                            String title,
                            int fadeIn,
                            int stay,
                            int fadeOut) {

        if (minecraft == null || minecraft.player == null) {
            return;
        }

        minecraft.gui.setTimes(fadeIn, stay, fadeOut);
        minecraft.gui.setTitle(Component.literal(title));
    }

    public static void show(Minecraft minecraft, String title) {

        show(
                minecraft,
                title,
                DEFAULT_FADE_IN,
                DEFAULT_STAY,
                DEFAULT_FADE_OUT
        );
    }

    public static void showEndOfFarm(Minecraft minecraft) {

        show(minecraft, "END OF FARM");

    }

    public static void showTeleportNow(Minecraft minecraft) {

        show(minecraft, "TELEPORT NOW");

    }
}