package com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.With;

import java.io.IOException;

@Data
@With
@AllArgsConstructor
public class ServerboundPlaceRecipePacket implements Packet {
    private final int containerId;
    private final @NonNull String recipeId;
    private final boolean makeAll;

    public ServerboundPlaceRecipePacket(NetInput in) throws IOException {
        this.containerId = in.readByte();
        this.recipeId = in.readString();
        this.makeAll = in.readBoolean();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeByte(this.containerId);
        out.writeString(this.recipeId);
        out.writeBoolean(this.makeAll);
    }
}
