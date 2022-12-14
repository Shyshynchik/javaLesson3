package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class MajorVersionBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(Blocks.MAJOR_VERSION.getSize());

        System.out.printf(format, Blocks.MAJOR_VERSION.getName(), Blocks.MAJOR_VERSION.getSize());

        return Blocks.MAJOR_VERSION.getSize();
    }
}
