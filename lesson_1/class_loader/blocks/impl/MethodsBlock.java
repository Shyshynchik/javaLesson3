package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class MethodsBlock extends CountReader implements Block {

    private byte[] count;

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        count = stream.readNBytes(Blocks.METHODS_COUNT.getSize());

        System.out.printf(format, Blocks.METHODS_COUNT.getName(), Blocks.METHODS_COUNT.getSize());

        return Blocks.METHODS_COUNT.getSize() + printMethodInfoSize(stream);
    }

    private int printMethodInfoSize(InputStream stream) throws IOException {
        int size = 0;

        for (int i = 0; i < getCount(count); i++) {
            stream.skipNBytes(Blocks.METHODS.getSize());

            int attributesCount = getCount(stream.readNBytes(Blocks.METHODS_COUNT.getSize()));

            int attributesSize = new AttributesBlock().getAttributesInfoSize(stream, attributesCount);

            size += Blocks.METHODS.getSize() + Blocks.METHODS_COUNT.getSize() + attributesSize;
        }

        System.out.printf(format, Blocks.METHODS.getName(), size);

        return size;
    }
}
