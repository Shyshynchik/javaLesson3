package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class SuperClassBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(Blocks.SUPER_CLASS.getSize());

        System.out.printf(format, Blocks.SUPER_CLASS.getName(), Blocks.SUPER_CLASS.getSize());

        return Blocks.SUPER_CLASS.getSize();
    }
}
