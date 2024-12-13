package org.nullhater.circlebattlefield.domain.core;

import org.nullhater.circlebattlefield.domain.core.annotation.ThreadSafe;

@ThreadSafe
public record Vector2(double x, double y) {

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2 normalize() {
        double magnitude = Math.sqrt(x * x + y * y);
        if (magnitude > 0) {
            return new Vector2(x / magnitude, y / magnitude);
        }
        return this;
    }
}
