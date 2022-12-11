package constants;

public enum BlockSizes {

    MAGIC_NUMBER(4),
    MINOR_VERSION(2),
    MAJOR_VERSION(2),
    CONSTANT_POOL_COUNT(2),
    ACCESS_FLAGS(2),
    THIS_CLASS(2),
    SUPER_CLASS(2),
    INTERFACES_COUNT(2),
    INTERFACES(2),
    FIELDS_COUNT(2),
    METHODS_COUNT(2),
    ATTRIBUTE_INFO(2);

    private final int size;

    BlockSizes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
