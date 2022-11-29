public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest that = new ClassLoaderTest();

        System.out.println("ClassLoaderTest class classloader - " + ClassLoaderTest.class.getClassLoader());

        var hm = new java.util.HashMap();
    }

    public void helloWorld() {
        System.out.println("Hello world");
    }
}
