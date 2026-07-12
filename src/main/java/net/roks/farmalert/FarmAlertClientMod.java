package net.roks.farmalert;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import net.roks.farmalert.service.TitleService;

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

                TitleService.showEndOfFarm();

            }

        });

    }
}