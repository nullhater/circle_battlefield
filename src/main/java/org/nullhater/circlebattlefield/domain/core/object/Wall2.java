package org.nullhater.circlebattlefield.domain.core.object;

import org.nullhater.circlebattlefield.domain.core.Vector2;

public record Wall2(
        Vector2 start,
        Vector2 end,
        double width
) {
}
