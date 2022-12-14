package blocks.impl;

import java.io.IOException;
import java.io.InputStream;

public interface AttributesInfoSizeReader {

    int getAttributesInfoSize(InputStream stream, int attributesSize) throws IOException;

}
