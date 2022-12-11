package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class MajorVersionBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(BlockSizes.MAJOR_VERSION.getSize());

        System.out.printf(format, BlockNames.MAJOR_VERSION.getName(), BlockSizes.MAJOR_VERSION.getSize());

        return BlockSizes.MAJOR_VERSION.getSize();
    }
}
