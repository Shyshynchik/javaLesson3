package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class MagicNumberBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(BlockSizes.MAGIC_NUMBER.getSize());

        System.out.printf(format, BlockNames.MAGIC_NUMBER.getName(), BlockSizes.MAGIC_NUMBER.getSize());

        return BlockSizes.MAGIC_NUMBER.getSize();
    }
}
