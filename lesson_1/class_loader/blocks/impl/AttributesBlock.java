package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class AttributesBlock extends CountReader implements Block, AttributesInfoSizeReader {

    private byte[] count;

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        count = stream.readNBytes(Blocks.ATTRIBUTE_COUNT.getSize());

        System.out.printf(format, Blocks.ATTRIBUTE_COUNT.getName(), Blocks.ATTRIBUTE_COUNT.getSize());

        return Blocks.ATTRIBUTE_COUNT.getSize() + printAttributeSize(stream);
    }

    private int printAttributeSize(InputStream stream) throws IOException {
        int attributesInfoSize = getAttributesInfoSize(stream, getCount(count));

        System.out.printf(format, Blocks.ATTRIBUTE.getName(), attributesInfoSize);

        return attributesInfoSize;
    }

    @Override
    public int getAttributesInfoSize(InputStream stream, int attributesSize) throws IOException {

        int size = 0;

        for (int i = 0; i < attributesSize; i++) {
            stream.skipNBytes(Blocks.ATTRIBUTE_COUNT.getSize());

            int attributesCount = getCount(stream.readNBytes(Blocks.ATTRIBUTE.getSize()));

            stream.skipNBytes(attributesCount);

            size += Blocks.ATTRIBUTE_COUNT.getSize() + Blocks.ATTRIBUTE.getSize() + attributesCount;
        }

        return size;
    }

}
