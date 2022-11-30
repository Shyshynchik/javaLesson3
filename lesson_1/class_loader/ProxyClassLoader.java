import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class ProxyClassLoader extends ClassLoader {
    public ProxyClassLoader(ClassLoader parent) {
        super(parent);
    }

    private Class<?> getClass(String name) throws ClassNotFoundException {
        System.out.println("\nCalling getClass " + name);
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b;
        try {
            b = loadClassFileData(file);

            Class<?> c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class '" + name + "'");

        if (isCustomClass(name)) {
            System.out.println("Loading Class using ProxyClassLoader");
            return getClass(name);
        }

        try {
            String file = name.replace('.', File.separatorChar) + ".class";
            var bytesArray = loadClassFileData(file);
            System.out.println("File size " + bytesArray.length + " B");

            for (byte el: bytesArray) {
                System.out.printf("%X ", el);
            }
            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return super.loadClass(name);
    }

    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(
                name);
        assert stream != null;

        int size = stream.available();
        byte[] buff = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }

    private boolean isCustomClass(String name) {
        return !name.contains(".");
    }
}
