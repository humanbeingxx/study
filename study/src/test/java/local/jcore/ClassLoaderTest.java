package local.jcore;

import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/15 下午7:20
 **/
public class ClassLoaderTest {

    class MyLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("MyClass.class"));
                Class<?> myClass = defineClass(null, bytes, 0, bytes.length);
                return myClass;
            } catch (Throwable e) {
                e.printStackTrace();
                throw new Error();
            }
        }

        ;
    }

    @Test
    public void testMyClass() throws ClassNotFoundException {
        MyLoader myLoader = new MyLoader();
        Class<?> myClass = myLoader.loadClass("MyClass");
        System.out.println(myClass.getName());
    }

    @Test
    public void testClassFile() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("rx.Observer");
        System.out.println(aClass);
    }
}
