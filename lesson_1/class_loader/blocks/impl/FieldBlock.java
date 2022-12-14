package blocks.impl;

import blocks.Block;
import constants.Blocks;

import java.io.IOException;
import java.io.InputStream;

public class FieldBlock extends CountReader implements Block {

    private byte[] count;

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        count = stream.readNBytes(Blocks.FIELDS_COUNT.getSize());

        System.out.printf(format, Blocks.FIELDS_COUNT.getName(), Blocks.FIELDS_COUNT.getSize());

        return Blocks.FIELDS_COUNT.getSize() + printFieldsInfoSize(stream);
    }

    private int printFieldsInfoSize(InputStream stream) throws IOException {
        int size = 0;

        for (int i = 0; i < getCount(count); i++) {
            stream.skipNBytes(Blocks.FIELDS.getSize());

            int attributesCount = getCount(stream.readNBytes(Blocks.FIELDS_COUNT.getSize()));

            int attributesSize = new AttributesBlock().getAttributesInfoSize(stream, attributesCount);

            size += Blocks.FIELDS.getSize() + Blocks.FIELDS_COUNT.getSize() + attributesSize;
        }

        System.out.printf(format, Blocks.FIELDS.getName(), size);

        return size;
    }
}
