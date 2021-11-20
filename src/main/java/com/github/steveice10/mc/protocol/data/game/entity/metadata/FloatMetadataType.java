package com.github.steveice10.mc.protocol.data.game.entity.metadata;

import com.github.steveice10.mc.protocol.data.game.entity.metadata.type.FloatEntityMetadata;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

import java.io.IOException;

public class FloatMetadataType extends MetadataType<Float> {
    private final FloatReader primitiveReader;
    private final FloatWriter primitiveWriter;
    private final FloatEntityMetadataFactory primitiveFactory;

    protected FloatMetadataType(FloatReader reader, FloatWriter writer, FloatEntityMetadataFactory metadataFactory) {
        super(reader, writer, metadataFactory);
        
        this.primitiveReader = reader;
        this.primitiveWriter = writer;
        this.primitiveFactory = metadataFactory;
    }

    @Override
    public EntityMetadata<Float, FloatMetadataType> readMetadata(NetInput input, int id) throws IOException {
        return this.primitiveFactory.createPrimitive(id, this, this.primitiveReader.readPrimitive(input));
    }

    public void writeMetadataPrimitive(NetOutput output, float value) throws IOException {
        this.primitiveWriter.writePrimitive(output, value);
    }

    @FunctionalInterface
    public interface FloatReader extends Reader<Float> {
        float readPrimitive(NetInput input) throws IOException;

        @Deprecated
        @Override
        default Float read(NetInput input) throws IOException {
            return this.readPrimitive(input);
        }
    }

    @FunctionalInterface
    public interface FloatWriter extends Writer<Float> {
        void writePrimitive(NetOutput output, float value) throws IOException;

        @Deprecated
        @Override
        default void write(NetOutput output, Float value) throws IOException {
            this.writePrimitive(output, value);
        }
    }

    @FunctionalInterface
    public interface FloatEntityMetadataFactory extends EntityMetadataFactory<Float> {
        FloatEntityMetadata createPrimitive(int id, FloatMetadataType type, float value);

        @Deprecated
        @Override
        default EntityMetadata<Float, FloatMetadataType> create(int id, MetadataType<Float> type, Float value) {
            throw new UnsupportedOperationException("Unsupported read method! Use primitive createPrimitive!");
        }
    }
}
