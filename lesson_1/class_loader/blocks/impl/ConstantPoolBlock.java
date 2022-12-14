package blocks.impl;

import blocks.Block;
import constants.Blocks;
import constants.ConstantPoolInfo;

import java.io.IOException;
import java.io.InputStream;

public class ConstantPoolBlock extends CountReader  implements Block {

    private byte[] count;

    @Override
    public int printBlockSize(InputStream stream) throws IOException {
        count = stream.readNBytes(Blocks.CONSTANT_POOL_COUNT.getSize());

        System.out.printf(format, Blocks.CONSTANT_POOL_COUNT.getName(), Blocks.CONSTANT_POOL_COUNT.getSize());

        return printConstantPollSize(stream) + Blocks.CONSTANT_POOL_COUNT.getSize();
    }

    private int printConstantPollSize(InputStream stream) throws IOException {

        int size = 0;

        for (int i = 1; i < getCount(count); i++) {
            int tag = stream.read();

            var constantPollBlock = ConstantPoolInfo.getByCode(tag);

            if (constantPollBlock == null) {
                System.out.println("Ошибка");
                System.out.println(i);
                continue;
            }

            size += constantPollBlock.getSize() + 1;

            if (constantPollBlock == ConstantPoolInfo.CONSTANT_UTF8) {
                int length = getCount(stream.readNBytes(constantPollBlock.getSize()));
                size += length;
                stream.skipNBytes(length);
                continue;
            }

            stream.skipNBytes(constantPollBlock.getSize());

        }
        System.out.printf(format, Blocks.CONSTANT_POOL.getName(), size);

        return size;
    }
}
