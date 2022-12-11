package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class ThisClassBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(BlockSizes.THIS_CLASS.getSize());

        System.out.printf(format, BlockNames.THIS_CLASS.getName(), BlockSizes.THIS_CLASS.getSize());

        return BlockSizes.THIS_CLASS.getSize();
    }
}
