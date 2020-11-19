package local.jcore;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/5 1:32
 */
public class ReflectionTest {

    @Test
    public void testMethod() {
        Method[] declaredMethods = this.getClass().getDeclaredMethods();
    }

    @Test
    public void testTime() throws Exception {
        class MyClass {
            public boolean call(int[] arr) {
                return arr.length > 0;
            }
        }

        MyClass obj = new MyClass();
        Method method = MyClass.class.getDeclaredMethod("call", int[].class);
        int[] ints = new int[10];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            obj.call(ints);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            method.invoke(obj, ints);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
