package net.roks.farmalert;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class FarmAlertClientMod implements ClientModInitializer {

    private int ticks = 0;

    @Override
    public void onInitializeClient() {

        FarmAlert.LOGGER.info("FarmAlert client loaded.");

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {

            if (minecraft.player == null) {
                return;
            }

            ticks++;

            if (ticks >= 100) {

                ticks = 0;

                minecraft.gui.setTimes(5, 40, 10);
                minecraft.gui.setTitle(Component.literal("TEST"));
            }
        });
    }
}