package local.jcore.dynamic;

import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.testng.Assert.*;

public class DynamicClassLoaderTest {

    @Test
    public void testFindClass() throws Exception {
        while (true) {
            Class<?> aClass = new DynamicClassLoader().findClass("local.jcore.dynamic.DynamicData");
            Field field = aClass.getDeclaredField("data");
            field.setAccessible(true);
            System.out.println(field.get(null));

            Class<?> innerClass = new DynamicClassLoader().findClass("local.jcore.dynamic.DynamicData$InnerData");
            Field innerField = innerClass.getDeclaredField("data");
            innerField.setAccessible(true);
            System.out.println(innerField.get(null));

            Thread.sleep(3000);
        }
    }
}