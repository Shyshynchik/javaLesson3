package blocks.impl;

public abstract class CountReader {

    protected int getCount(byte[] bytes) {
        int sum = 0;

        for (byte b : bytes) {
            sum = (sum << 8) + (b & 0xFF);
        }

        return sum;
    }

}
