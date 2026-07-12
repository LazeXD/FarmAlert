package net.roks.farmalert.service;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

import net.roks.farmalert.model.Position;

public final class PositionService {

    private static Position currentPosition = new Position(0, 0, 0);

    private PositionService() {
    }

    public static void update() {

        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft == null) {
            return;
        }

        Player player = minecraft.player;

        if (player == null) {
            return;
        }

        currentPosition = new Position(
                player.getX(),
                player.getY(),
                player.getZ()
        );
    }

    public static Position getCurrentPosition() {
        return currentPosition;
    }
}