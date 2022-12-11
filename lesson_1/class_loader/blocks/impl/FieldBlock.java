package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class FieldBlock extends CountReader implements Block {
    private byte[] count;

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        count = stream.readNBytes(BlockSizes.FIELDS_COUNT.getSize());

        System.out.printf(format, BlockNames.FIELDS_COUNT.getName(), BlockSizes.FIELDS_COUNT.getSize());

        System.out.println(getCount(count));

        return BlockSizes.FIELDS_COUNT.getSize();
    }
}
