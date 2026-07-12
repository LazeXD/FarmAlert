package net.roks.farmalert.config.screen;

import net.roks.farmalert.service.ConfigService;

import net.roks.farmalert.config.FarmAlertConfig;
import net.roks.farmalert.config.EdgeConfig;
import net.roks.farmalert.config.TeleportConfig;

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
        FarmAlertConfig config = ConfigService.getConfig();
        EdgeConfig edgeConfig = config.edge;

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
        edge.addEntry(

                entryBuilder.startBooleanToggle(
                                Component.literal("Enable X"),
                                config.edge.xEnabled
                        )
                        .setDefaultValue(true)
                        .setSaveConsumer(value -> config.edge.xEnabled = value)
                        .build()

        );

        return builder.build();

    }

}