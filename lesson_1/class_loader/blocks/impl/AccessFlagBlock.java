package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class AccessFlagBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(BlockSizes.ACCESS_FLAGS.getSize());

        System.out.printf(format, BlockNames.ACCESS_FLAGS.getName(), BlockSizes.ACCESS_FLAGS.getSize());

        return BlockSizes.ACCESS_FLAGS.getSize();
    }
}
