package local.interview_internal_reference.tencent;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/9 1:46
 */
public class MethodInvokeTest {

    class Temp {
        public void show() {
        }
    }

    @Test
    public void test() throws Exception {
        Method method = Temp.class.getMethod("show");
        method.invoke(new Temp());
    }

    class TempSuper {
        public void act() {
            System.out.println("this is super");
        }
    }

    class TempExtend extends TempSuper {
        @Override
        public void act() {
            System.out.println("this is extend");
        }
    }

    @Test
    public void testInvokeWithExtend() throws Exception {
        TempSuper objSuper = new TempSuper();
        TempSuper objExtend = new TempExtend();

        Method methodSuper = TempSuper.class.getMethod("act");
        Method methodExtend = TempExtend.class.getMethod("act");

        methodSuper.invoke(objExtend);
        methodExtend.invoke(objSuper);
    }
}