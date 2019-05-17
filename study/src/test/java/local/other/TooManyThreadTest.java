package local.other;

import org.testng.annotations.Test;

/**
 * @date 2019-05-06
 **/
public class TooManyThreadTest {

    class MyThread extends Thread {
        private int[] data;

        public MyThread() {
            this.data = new int[1024];
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testMany() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new MyThread().start();
        }

        System.out.println("finish new Threads");
        Thread.sleep(1000000);
    }
}
