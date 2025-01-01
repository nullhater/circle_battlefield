package org.nullhater.circlebattlefield.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import org.nullhater.circlebattlefield.domain.core.Vector2;
import org.nullhater.circlebattlefield.domain.core.port.PlayerMovementPort;
import org.nullhater.circlebattlefield.infrastructure.engine.input.Input;

@RequiredArgsConstructor
public class PlayerMovementAdapter implements PlayerMovementPort {

    private final Input input;

    @Override
    public Vector2 getDirection() {
        int xAxis = 0;
        int yAxis = 0;
        if (input.isKeyPressed("W")) {
            yAxis++;
        }
        if (input.isKeyPressed("S")) {
            yAxis--;
        }
        if (input.isKeyPressed("D")) {
            xAxis++;
        }
        if (input.isKeyPressed("A")) {
            xAxis--;
        }
        return new Vector2(xAxis, yAxis);
    }
}
