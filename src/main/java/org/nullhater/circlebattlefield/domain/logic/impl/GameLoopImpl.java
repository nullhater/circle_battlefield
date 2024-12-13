package org.nullhater.circlebattlefield.domain.logic.impl;

import org.nullhater.circlebattlefield.domain.core.Player;
import org.nullhater.circlebattlefield.domain.core.port.PlayerMovementPort;
import org.nullhater.circlebattlefield.domain.core.port.PlayerRenderPort;
import org.nullhater.circlebattlefield.domain.logic.GameLoop;

public class GameLoopImpl implements GameLoop {

    private final Player player;
    private final PlayerMovementPort playerMovementPort;
    private final PlayerRenderPort playerRenderPort;

    private long lastTime;

    public GameLoopImpl(Player player,
                        PlayerMovementPort playerMovementPort,
                        PlayerRenderPort playerRenderPort) {
        this.player = player;
        this.playerMovementPort = playerMovementPort;
        this.playerRenderPort = playerRenderPort;
        lastTime = System.currentTimeMillis();
    }

    @Override
    public void loop() {
        long currentTime = System.currentTimeMillis();
        long deltaTime = (currentTime - lastTime) / 1000;
        lastTime = currentTime;
        player.move(playerMovementPort.getDirection(), 2L, deltaTime);
        playerRenderPort.render(player);
    }
}
