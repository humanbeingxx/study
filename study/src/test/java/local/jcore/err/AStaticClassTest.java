package local.jcore.err;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/29 下午7:36
 **/
public class AStaticClassTest {

    @Test
    public void test() {
        try {
            Object object = AStaticClass.A_STATIC_OBJECT;
        } catch (Throwable e) {
            e.printStackTrace();
        }

        Object object2 = AStaticClass.A_STATIC_OBJECT;

    }

}