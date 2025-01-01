package org.nullhater.circlebattlefield.domain.core;

import org.nullhater.circlebattlefield.domain.core.behavior.Movable2;

public class Player implements Movable2 {

    private double x;
    private double y;

    @Override
    public void move(Vector2 direction, long speedCoefficient, double deltaTime) {
        double nativeSpeed = direction.length();
        if (nativeSpeed > 1D) {
            nativeSpeed = 1D;
        }
        direction = direction.normalize();
        x = x + (direction.x() * nativeSpeed * speedCoefficient * deltaTime);
        y = y + (direction.y() * nativeSpeed * speedCoefficient * deltaTime);
    }

    public Point2 getPosition() {
        return new Point2(x, y);
    }
}
