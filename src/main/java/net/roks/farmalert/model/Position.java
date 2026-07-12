package net.roks.farmalert.model;

public record Position(double x, double y, double z) {

    public boolean withinX(double target, double tolerance) {
        return Math.abs(x - target) <= tolerance;
    }

    public boolean withinY(double target, double tolerance) {
        return Math.abs(y - target) <= tolerance;
    }

    public boolean withinZ(double target, double tolerance) {
        return Math.abs(z - target) <= tolerance;
    }

    public boolean withinXYZ(Position target,
                             double xTolerance,
                             double yTolerance,
                             double zTolerance) {

        return withinX(target.x(), xTolerance)
                && withinY(target.y(), yTolerance)
                && withinZ(target.z(), zTolerance);

    }
}