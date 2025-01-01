package org.nullhater.circlebattlefield.infrastructure.engine.input.impl;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.nullhater.circlebattlefield.domain.core.annotation.ThreadSafe;
import org.nullhater.circlebattlefield.infrastructure.engine.input.Input;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class InputImpl implements Input, EventHandler<KeyEvent> {

    private final Set<Integer> keysWerePressed = ConcurrentHashMap.newKeySet();

    @Override
    public void handle(KeyEvent event) {
        keysWerePressed.add(event.getCode().getCode());
    }

    @Override
    public boolean isKeyPressed(String key) {
        return keysWerePressed.remove(KeyCode.valueOf(key.toUpperCase()).getCode());
    }
}
