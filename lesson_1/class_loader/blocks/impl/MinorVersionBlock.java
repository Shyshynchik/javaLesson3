package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class MinorVersionBlock implements Block {

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(BlockSizes.MINOR_VERSION.getSize());

        System.out.printf(format, BlockNames.MINOR_VERSION.getName(), BlockSizes.MINOR_VERSION.getSize());

        return BlockSizes.MINOR_VERSION.getSize();
    }
}
