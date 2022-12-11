package constants;

public enum ConstantPoolInfo {

    CONSTANT_CLASS(7, 2),
    CONSTANT_FIELD_REF(9, 4),
    CONSTANT_METHOD_REF(10, 4),
    CONSTANT_INTERFACE_METHOD_REF(11, 4),
    CONSTANT_STRING(8, 2),
    CONSTANT_INTEGER(3, 4),
    CONSTANT_FLOAT(4, 4),
    CONSTANT_LONG(5, 8),
    CONSTANT_DOUBLE(6, 8),
    CONSTANT_NAME_AND_TYPE(12, 4),
    CONSTANT_UTF8(1, 2),
    CONSTANT_METHOD_HANDLE(15, 3),
    CONSTANT_METHOD_TYPE(16, 2),
    CONSTANT_INVOKE_DYNAMIC(18, 4);

    private final int code;
    private final int size;

    ConstantPoolInfo(int code, int size) {
        this.code = code;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static ConstantPoolInfo getByCode(int code) {
        for (var value: ConstantPoolInfo.values()) {
            if (value.code == code) {
                return value;
            }
        }

        return null;
    }
}
