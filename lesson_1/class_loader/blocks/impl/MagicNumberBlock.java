package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class MagicNumberBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(Blocks.MAGIC_NUMBER.getSize());

        System.out.printf(format, Blocks.MAGIC_NUMBER.getName(), Blocks.MAGIC_NUMBER.getSize());

        return Blocks.MAGIC_NUMBER.getSize();
    }
}
