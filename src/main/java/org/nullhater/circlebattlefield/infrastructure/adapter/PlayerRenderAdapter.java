package org.nullhater.circlebattlefield.infrastructure.adapter;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lombok.extern.slf4j.Slf4j;
import org.nullhater.circlebattlefield.domain.core.Player;
import org.nullhater.circlebattlefield.domain.core.port.PlayerRenderPort;

@Slf4j
public class PlayerRenderAdapter implements PlayerRenderPort {

    private final Circle circle;

    public PlayerRenderAdapter(Pane pane) {
        circle = new Circle(0, 0, 20);
        circle.setFill(Color.RED);
        pane.getChildren().add(circle);
    }

    @Override
    public void render(Player player) {
        circle.setCenterX(player.getPosition().x());
        circle.setCenterY(player.getPosition().y());
    }
}
