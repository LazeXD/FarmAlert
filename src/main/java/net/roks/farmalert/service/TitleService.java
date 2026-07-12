package net.roks.farmalert.service;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import net.roks.farmalert.constant.Constants;

public final class TitleService {

    private TitleService() {
    }

    private static Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }

    public static void show(String title,
                            int fadeIn,
                            int stay,
                            int fadeOut) {

        Minecraft minecraft = getMinecraft();

        if (minecraft == null || minecraft.player == null) {
            return;
        }

        minecraft.gui.setTimes(fadeIn, stay, fadeOut);
        minecraft.gui.setTitle(Component.literal(title));
    }

    public static void show(String title) {

        show(
                title,
                Constants.DEFAULT_TITLE_FADE_IN,
                Constants.DEFAULT_TITLE_STAY,
                Constants.DEFAULT_TITLE_FADE_OUT
        );

    }

    public static void showEndOfFarm() {

        show(Constants.TITLE_END_OF_FARM);

    }

    public static void showTeleportNow() {

        show(Constants.TITLE_TELEPORT_NOW);

    }
}