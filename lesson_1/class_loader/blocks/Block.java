package blocks;

import java.io.IOException;
import java.io.InputStream;

public interface Block {

    String format = "%s %dB\n";

    int printBlockSize(InputStream stream) throws IOException;

}
