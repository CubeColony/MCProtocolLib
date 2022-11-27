package com.github.steveice10.mc.protocol.data.game.inventory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContainerType {
    GENERIC_9X1(9),
    GENERIC_9X2(18),
    GENERIC_9X3(27),
    GENERIC_9X4(36),
    GENERIC_9X5(45),
    GENERIC_9X6(54),
    GENERIC_3X3(9),
    ANVIL(3),
    BEACON(1),
    BLAST_FURNACE(3),
    BREWING_STAND(5),
    CRAFTING(10),
    ENCHANTMENT(2),
    FURNACE(3),
    GRINDSTONE(3),
    HOPPER(5),
    LECTERN(1),
    LOOM(4),
    MERCHANT(3),
    SHULKER_BOX(27),
    SMITHING(3),
    SMOKER(3),
    CARTOGRAPHY(3),
    STONECUTTER(1);

    private final int slots;
}
