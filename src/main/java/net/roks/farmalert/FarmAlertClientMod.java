package net.roks.farmalert;

import net.fabricmc.api.ClientModInitializer;

public class FarmAlertClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        FarmAlert.LOGGER.info("==================================");
        FarmAlert.LOGGER.info(" FarmAlert Client Loaded ");
        FarmAlert.LOGGER.info("==================================");

    }
}