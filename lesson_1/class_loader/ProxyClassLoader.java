import blocks.*;
import blocks.impl.*;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProxyClassLoader extends ClassLoader {

    private static final List<Block> blocks = new ArrayList<>(
            List.of(
                    new MagicNumberBlock(),
                    new MajorVersionBlock(),
                    new MinorVersionBlock(),
                    new ConstantPoolBlock(),
                    new AccessFlagBlock(),
                    new ThisClassBlock(),
                    new SuperClassBlock(),
                    new InterfacesBlock(),
                    new FieldBlock(),
                    new MethodsBlock(),
                    new AttributesBlock()
            )
    );

    public ProxyClassLoader(ClassLoader parent) {
        super(parent);
    }

    private Class<?> getClass(String name) throws ClassNotFoundException {
        String file = getFileName(name);
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
        System.out.println("Class '" + name + "'");

        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(getFileName(name))) {

            System.out.println("Total size = " + stream.readAllBytes().length + "B");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        readBlocksBytes(getFileName(name));
        System.out.println();

        if (isCustomClass(name)) {
            return getClass(name);
        }

        return super.loadClass(name);
    }

    private void readBlocksBytes(String fileName) {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName)) {

            int size = 0;

            for (Block block: blocks) {
                size += block.printBlockSize(stream);
            }

            System.out.println("Total size = " + size + "B\n");

        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }

    private String getFileName(String name) {
        return name.replace('.', File.separatorChar) + ".class";
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
