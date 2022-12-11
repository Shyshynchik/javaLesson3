package constants;

public enum BlockNames {

    MAGIC_NUMBER("Magic number"),
    MINOR_VERSION("Minor version"),
    MAJOR_VERSION("Major version"),
    CONSTANT_POOL_COUNT("Constant pool count"),
    CONSTANT_POOL("Constant pool"),
    ACCESS_FLAGS("Access flags"),
    THIS_CLASS("This class"),
    SUPER_CLASS("Super class"),
    INTERFACES_COUNT("Interfaces count"),
    INTERFACES("Interfaces"),
    FIELDS_COUNT("Fields count"),
    FIELDS("Fields"),
    METHODS_COUNT("Methods count"),
    METHODS("Methods"),
    ATTRIBUTE_COUNT("Attribute count"),
    ATTRIBUTE_INFO("Attribute info");

    private final String name;

    BlockNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
