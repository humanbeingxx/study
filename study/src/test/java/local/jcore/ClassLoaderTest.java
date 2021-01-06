package local.jcore;

import com.sun.java.accessibility.util.EventID;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/15 下午7:20
 **/
public class ClassLoaderTest {

    class MyLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("E:\\MyClass.class"));
                Class<?> myClass = defineClass(null, bytes, 0, bytes.length);
                return myClass;
            } catch (Throwable e) {
                e.printStackTrace();
                throw new Error();
            }
        }
    }

    @Test
    public void testMyClass() throws Exception {
        MyLoader myLoader = new MyLoader();
        Class<?> myClass = myLoader.loadClass("MyClass");
        System.out.println(myClass.getName());
    }

    @Test
    public void testClassFile() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("rx.Observer");
        System.out.println(aClass);
    }

    @Test
    public void testForNameTime() throws ClassNotFoundException {
        Map<String, Class> cache = Maps.newHashMap();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            if (!cache.containsKey("local.jcore.ClassLoaderTest")) {
                cache.put("local.jcore.ClassLoaderTest", Class.forName("local.jcore.ClassLoaderTest"));
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testUrlLoaderFromDifferentPos() throws MalformedURLException, ClassNotFoundException {
        URLClassLoader loader1 = new URLClassLoader(new URL[]{
                new URL("file:" + ClassLoaderTest.class.getProtectionDomain().getCodeSource().getLocation())
        });

        Class<?> classIn = loader1.loadClass("local.jcore.AutoBoxTest");
        Assert.assertNotNull(classIn);

        Class<?> classOut = loader1.loadClass("local.other.MyObject");
        Assert.assertNotNull(classOut);
    }

    @Test
    public void temp() {
        ClassLoader classLoader = EventID.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
