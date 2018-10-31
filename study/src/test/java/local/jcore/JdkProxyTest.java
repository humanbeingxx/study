package local.jcore;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/29 上午1:05
 **/
public class JdkProxyTest {

    public interface Test1 {
        void test1();
    }


    public interface Test2 {
        void test2();
    }


    public interface Test3 {
        void test1();
    }

    public static class TestProxyTarget implements Test1, Test2, Test3 {

        @Override
        public void test1() {

        }

        @Override
        public void test2() {

        }
    }

    @Test
    public void test() {
        TestProxyTarget target = new TestProxyTarget();
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Test1.class, Test2.class, Test3.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                Object ret = method.invoke(target, args);
                System.out.println("after");
                return ret;
            }
        });
        ((Test1)proxy).test1();
    }
}
