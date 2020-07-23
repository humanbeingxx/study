package local.interview_internal_reference.tencent;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/9 1:46
 */
public class MethodInvokeTest {

    class Temp {
        public void show(){}
    }

    @Test
    public void test() throws Exception {
        Method method = Temp.class.getMethod("show");
        method.invoke(new Temp());
    }
}