package constants;

public enum Blocks {

    MAGIC_NUMBER("Magic number", 4),
    MINOR_VERSION("Minor version", 2),
    MAJOR_VERSION("Major version", 2),
    CONSTANT_POOL_COUNT("Constant pool count", 2),
    CONSTANT_POOL("Constant pool", 0),
    ACCESS_FLAGS("Access flags", 2),
    THIS_CLASS("This class", 2),
    SUPER_CLASS("Super class", 2),
    INTERFACES_COUNT("Interfaces count", 2),
    INTERFACES("Interfaces", 2),
    FIELDS_COUNT("Fields count", 2),
    FIELDS("Fields", 6),
    METHODS_COUNT("Methods count", 2),
    METHODS("Methods", 6),
    ATTRIBUTE_COUNT("Attributes count", 2),
    ATTRIBUTE("Attributes", 4);

    private final String name;
    private final int size;

    Blocks(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

}
