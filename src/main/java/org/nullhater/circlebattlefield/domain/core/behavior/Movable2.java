package org.nullhater.circlebattlefield.domain.core.behavior;

import org.nullhater.circlebattlefield.domain.core.Vector2;

public interface Movable2 {

    void move(Vector2 direction, Long speedCoefficient, Long deltaTime);
}
