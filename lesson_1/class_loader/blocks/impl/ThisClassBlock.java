package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class ThisClassBlock implements Block {
    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        stream.skipNBytes(Blocks.THIS_CLASS.getSize());

        System.out.printf(format, Blocks.THIS_CLASS.getName(), Blocks.THIS_CLASS.getSize());

        return Blocks.THIS_CLASS.getSize();
    }
}
