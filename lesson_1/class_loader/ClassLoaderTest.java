import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public final class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest that = new ClassLoaderTest();

        System.out.println("ClassLoaderTest class classloader - " + ClassLoaderTest.class.getClassLoader());

        var hm = new HashMap();
        var test = new Double(123);
    }

    public void helloWorld() {
        System.out.println("Hello world");
    }
}
