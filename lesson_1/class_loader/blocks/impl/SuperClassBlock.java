package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class SuperClassBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(BlockSizes.SUPER_CLASS.getSize());

        System.out.printf(format, BlockNames.SUPER_CLASS.getName(), BlockSizes.SUPER_CLASS.getSize());

        return BlockSizes.SUPER_CLASS.getSize();
    }
}
