package org.nullhater.circlebattlefield.infrastructure.engine.input.impl;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import lombok.extern.slf4j.Slf4j;
import org.nullhater.circlebattlefield.domain.core.annotation.ThreadSafe;
import org.nullhater.circlebattlefield.infrastructure.engine.input.Input;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ThreadSafe
public class InputImpl implements Input {

    private final Set<Integer> keysPressed = ConcurrentHashMap.newKeySet();

    public InputImpl(Scene scene) {
        setListeners(scene);
    }

    protected void setListeners(Scene scene) {
        scene.setOnKeyPressed(event -> keysPressed.add(event.getCode().getCode()));
        scene.setOnKeyReleased(event -> keysPressed.remove(event.getCode().getCode()));
    }


    @Override
    public boolean isKeyPressed(String key) {
        return keysPressed.contains(KeyCode.valueOf(key.toUpperCase()).getCode());
    }
}
