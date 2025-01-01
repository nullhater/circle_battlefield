package org.nullhater.circlebattlefield.infrastructure.engine.input.impl;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.nullhater.circlebattlefield.domain.core.annotation.ThreadSafe;
import org.nullhater.circlebattlefield.infrastructure.engine.input.Input;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//TODO This implementations works only with one pressed button and can't detect that
// some button may be pressed at the same time. setOnKeyPressed doesn't work in this case, other options need to be found
// for registering multiply pushed buttons
@Slf4j
@ThreadSafe
public class InputImpl implements Input, EventHandler<KeyEvent> {

    private final Set<Integer> keysWerePressed = ConcurrentHashMap.newKeySet();

    @Override
    public void handle(KeyEvent event) {
        log.info("input:{}", event.getText());
        keysWerePressed.add(event.getCode().getCode());
    }

    @Override
    public boolean isKeyPressed(String key) {
        return keysWerePressed.remove(KeyCode.valueOf(key.toUpperCase()).getCode());
    }
}
