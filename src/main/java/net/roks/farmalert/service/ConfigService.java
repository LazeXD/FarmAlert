package net.roks.farmalert.service;

import net.roks.farmalert.config.FarmAlertConfig;
import net.roks.farmalert.config.io.ConfigManager;

public final class ConfigService {

    private static FarmAlertConfig config;

    private ConfigService() {
    }

    public static void load() {

        config = ConfigManager.load();

    }

    public static void save() {

        ConfigManager.save(config);

    }

    public static FarmAlertConfig getConfig() {

        if (config == null) {
            load();
        }

        return config;

    }

}