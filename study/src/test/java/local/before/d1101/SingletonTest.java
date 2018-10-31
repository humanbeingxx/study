package local.before.d1101;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/31 下午5:25
 **/
public class SingletonTest {

    @Test
    public void test() throws ClassNotFoundException {
        System.out.println(Class.forName("local.before.d1101.Single1"));
        System.out.println(Class.forName("local.before.d1101.Single2"));
    }

    @Test
    public void test2() {
        System.out.println(Single1.getSINGLETON());
        System.out.println(Single2.getSINGLETON());
    }
}
