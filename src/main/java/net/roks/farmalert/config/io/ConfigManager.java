package net.roks.farmalert.config.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.client.Minecraft;

import net.roks.farmalert.config.FarmAlertConfig;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigManager {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private static final Path CONFIG_FILE =
            Minecraft.getInstance()
                    .gameDirectory
                    .toPath()
                    .resolve("config")
                    .resolve("farmalert.json");

    private ConfigManager() {
    }

    public static FarmAlertConfig load() {

        if (!Files.exists(CONFIG_FILE)) {
            return new FarmAlertConfig();
        }

        try (Reader reader = Files.newBufferedReader(CONFIG_FILE)) {

            FarmAlertConfig config =
                    GSON.fromJson(reader, FarmAlertConfig.class);

            return config != null
                    ? config
                    : new FarmAlertConfig();

        } catch (IOException e) {

            e.printStackTrace();

            return new FarmAlertConfig();

        }

    }

    public static void save(FarmAlertConfig config) {

        try {

            Files.createDirectories(CONFIG_FILE.getParent());

            try (Writer writer = Files.newBufferedWriter(CONFIG_FILE)) {

                GSON.toJson(config, writer);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}