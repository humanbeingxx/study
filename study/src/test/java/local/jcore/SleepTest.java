package local.jcore;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/9 下午5:12
 **/
public class SleepTest {

    private List<Long> time = Lists.newArrayList();

    @Test
    public void test() throws InterruptedException {
        List<Thread> threadList = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            final int j = i;
            threadList.add(new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(System.nanoTime() - time.get(j));
                    if (System.nanoTime() - time.get(j) > 10) {
                        System.out.println("!!!!!!!!!!!!!");
                    }
                }
            }));
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        Thread.sleep(1000);
        for (Thread thread : threadList) {
            long startTime = System.nanoTime();
            time.add(startTime);
            thread.interrupt();
        }

        Thread.sleep(10000);
    }
}
