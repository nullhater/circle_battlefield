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
        lastTime = System.nanoTime();
    }

    @Override
    public void loop() {
        long currentTime = System.nanoTime();
        double deltaTime = (double) (currentTime - lastTime) / 1_000_000_000L;
        lastTime = currentTime;
        player.move(playerMovementPort.getDirection(), 1L, deltaTime);
        playerRenderPort.render(player);
    }
}
