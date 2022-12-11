package blocks.impl;

import blocks.Block;
import constants.BlockNames;
import constants.BlockSizes;

import java.io.IOException;
import java.io.InputStream;

public class InterfacesBlock extends CountReader  implements Block {
    private byte[] count;

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        count = stream.readNBytes(BlockSizes.INTERFACES_COUNT.getSize());

        System.out.printf(format, BlockNames.INTERFACES_COUNT.getName(), BlockSizes.INTERFACES_COUNT.getSize());

        System.out.println(getCount(count));

        return BlockSizes.INTERFACES_COUNT.getSize() + printInterfacesBlock(stream);
    }

    private int printInterfacesBlock(InputStream stream) throws IOException {
        int size = getCount(count) * BlockSizes.INTERFACES_COUNT.getSize();

        stream.skipNBytes(size);

        System.out.printf(format, BlockNames.INTERFACES.getName(), size);

        return size;
    }
}
