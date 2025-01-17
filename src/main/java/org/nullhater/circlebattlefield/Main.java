package org.nullhater.circlebattlefield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.nullhater.circlebattlefield.domain.core.GameField;
import org.nullhater.circlebattlefield.domain.core.Player;
import org.nullhater.circlebattlefield.domain.core.Vector2;
import org.nullhater.circlebattlefield.domain.core.object.Wall2;
import org.nullhater.circlebattlefield.domain.core.port.PlayerMovementPort;
import org.nullhater.circlebattlefield.domain.core.port.PlayerRenderPort;
import org.nullhater.circlebattlefield.domain.logic.GameLoop;
import org.nullhater.circlebattlefield.domain.logic.impl.GameLoopImpl;
import org.nullhater.circlebattlefield.infrastructure.adapter.PlayerMovementAdapter;
import org.nullhater.circlebattlefield.infrastructure.adapter.PlayerRenderAdapter;
import org.nullhater.circlebattlefield.infrastructure.engine.input.Input;
import org.nullhater.circlebattlefield.infrastructure.engine.input.impl.InputImpl;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main extends Application {

    private static final double TARGET_FPS = 60;
    private static final long TARGET_TIME_BETWEEN_UPDATES = (long) (1000 / TARGET_FPS); // в миллисекундах

    private final ScheduledExecutorService gameLoopExecutor = Executors.newScheduledThreadPool(1,
            r -> new Thread(r, "game-loop-thread"));

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1024, 576);
        stage.setScene(scene);
        stage.setTitle("Circle Battlefield");
        stage.show();
        Player player = new Player();
        GameField gameField = new GameField(player,
                List.of(
                        new Wall2(new Vector2(0, 0), new Vector2(0, 50), 0.2),
                        new Wall2(new Vector2(0, 50), new Vector2(50, 50), 0.2),
                        new Wall2(new Vector2(50, 50), new Vector2(50, 0), 0.2),
                        new Wall2(new Vector2(50, 0), new Vector2(0, 0), 0.2))
        );
        Input input = new InputImpl(scene);
        PlayerMovementPort playerMovementPort = new PlayerMovementAdapter(input);
        PlayerRenderPort playerRenderPort = new PlayerRenderAdapter(pane);
        GameLoop gameLoop = new GameLoopImpl(player, gameField, playerMovementPort, playerRenderPort);
        gameLoopExecutor.scheduleAtFixedRate(
                gameLoop::loop,
                0,
                TARGET_TIME_BETWEEN_UPDATES,
                TimeUnit.MILLISECONDS);
        log.info("App started");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        gameLoopExecutor.shutdown();
        boolean shutdownResult = gameLoopExecutor.awaitTermination(3L, TimeUnit.SECONDS);
        if (shutdownResult) {
            log.info("Game loop gracefully terminated");
        }
    }
}