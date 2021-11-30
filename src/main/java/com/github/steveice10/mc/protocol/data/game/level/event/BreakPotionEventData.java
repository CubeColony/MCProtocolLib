package com.github.steveice10.mc.protocol.data.game.level.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BreakPotionEventData implements LevelEventData {
    private final int potionId;
}
