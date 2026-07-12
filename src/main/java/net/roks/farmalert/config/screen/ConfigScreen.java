package net.roks.farmalert.config.screen;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class ConfigScreen {

    private ConfigScreen() {
    }

    public static Screen create(Screen parent) {

        ConfigBuilder builder = ConfigBuilder.create();

        builder.setParentScreen(parent);

        builder.setTitle(
                Component.literal("FarmAlert")
        );

        ConfigCategory edge =
                builder.getOrCreateCategory(
                        Component.literal("Edge Detection")
                );

        ConfigEntryBuilder entryBuilder =
                builder.entryBuilder();

        return builder.build();

    }

}