package org.nullhater.circlebattlefield.domain.core;

import lombok.Data;
import org.nullhater.circlebattlefield.domain.core.object.Wall2;

import java.util.List;

@Data
public class GameField {
    private final Player player;
    private final List<Wall2> walls;
}
