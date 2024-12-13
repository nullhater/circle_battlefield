package org.nullhater.circlebattlefield.domain.core;

import org.nullhater.circlebattlefield.domain.core.annotation.ThreadSafe;

@ThreadSafe
public record Point2(double x, double y) {
}
