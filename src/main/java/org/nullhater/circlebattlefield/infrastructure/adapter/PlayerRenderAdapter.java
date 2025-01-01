package org.nullhater.circlebattlefield.infrastructure.adapter;

import lombok.extern.slf4j.Slf4j;
import org.nullhater.circlebattlefield.domain.core.Player;
import org.nullhater.circlebattlefield.domain.core.port.PlayerRenderPort;

@Slf4j
public class PlayerRenderAdapter implements PlayerRenderPort {

    @Override
    public void render(Player player) {
        log.info("player position: {}", player.getPosition());
    }
}
