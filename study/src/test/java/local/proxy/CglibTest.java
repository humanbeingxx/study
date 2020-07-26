package local.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/26 1:31
 */
public class CglibTest {

    public static class NeedProxy {
        public void action() {
            System.out.println("this is original action");
            action2();
        }

        public void action2() {
            System.out.println("this is original action2");
        }
    }

    public static class MyCallBack1 implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("my callback1 start");
            methodProxy.invokeSuper(o, objects);
            System.out.println("my callback1 end");
            return null;
        }
    }

    public static class MyCallBack2 implements MethodInterceptor {

        private Object target;

        public MyCallBack2(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("my callback2 start");
            method.invoke(target, objects);
            System.out.println("my callback2 end");
            return null;
        }
    }

    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(NeedProxy.class);
        enhancer.setCallback(new MyCallBack1());
        NeedProxy proxy1 = (NeedProxy) enhancer.create();
        proxy1.action();

        System.out.println("*************test2************");
        NeedProxy proxy2 = (NeedProxy) Enhancer.create(NeedProxy.class, new MyCallBack2(new NeedProxy()));
        proxy2.action();
    }
}
