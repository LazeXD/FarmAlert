package net.roks.farmalert.detector;

import net.roks.farmalert.model.Position;
import net.roks.farmalert.service.PositionService;
import net.roks.farmalert.service.TitleService;

public final class EdgeDetector {

    /*
     * Temporary values for Milestone 5.
     * These will move to the config later.
     */
    private static final double TEST_X = 0.0;
    private static final double TOLERANCE = 0.15;

    /*
     * Prevents repeated triggering while standing
     * inside the trigger zone.
     */
    private static boolean insideTriggerZone = false;

    private EdgeDetector() {
    }

    public static void check() {

        Position position = PositionService.getCurrentPosition();

        boolean inside = position.withinX(TEST_X, TOLERANCE);

        if (!inside) {
            insideTriggerZone = false;
            return;
        }

        if (insideTriggerZone) {
            return;
        }

        insideTriggerZone = true;

        TitleService.showEndOfFarm();
    }
}