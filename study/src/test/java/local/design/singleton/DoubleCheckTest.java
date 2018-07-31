package local.design.singleton;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:10
 **/
public class DoubleCheckTest {

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                final DoubleCheck instance = DoubleCheck.getInstance();
                System.out.println(instance);
            }).start();
        }
        Thread.sleep(1000);
    }
}
