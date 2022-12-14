package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class MinorVersionBlock implements Block {

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(Blocks.MINOR_VERSION.getSize());

        System.out.printf(format, Blocks.MINOR_VERSION.getName(), Blocks.MINOR_VERSION.getSize());

        return Blocks.MINOR_VERSION.getSize();
    }
}
