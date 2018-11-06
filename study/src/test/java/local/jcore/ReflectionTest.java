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
}
