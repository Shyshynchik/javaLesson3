package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class InterfacesBlock extends CountReader  implements Block {
    private byte[] count;

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        count = stream.readNBytes(Blocks.INTERFACES_COUNT.getSize());

        System.out.printf(format, Blocks.INTERFACES_COUNT.getName(), Blocks.INTERFACES_COUNT.getSize());

        return Blocks.INTERFACES_COUNT.getSize() + printInterfacesBlock(stream);
    }

    private int printInterfacesBlock(InputStream stream) throws IOException {
        int size = getCount(count) * Blocks.INTERFACES_COUNT.getSize();

        stream.skipNBytes(size);

        System.out.printf(format, Blocks.INTERFACES.getName(), size);

        return size;
    }
}
