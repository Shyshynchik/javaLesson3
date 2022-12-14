package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class AccessFlagBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(Blocks.ACCESS_FLAGS.getSize());

        System.out.printf(format, Blocks.ACCESS_FLAGS.getName(), Blocks.ACCESS_FLAGS.getSize());

        return Blocks.ACCESS_FLAGS.getSize();
    }
}
