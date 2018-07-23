package local.other;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/18 下午5:57
 **/
public class CyclicBarrierTest {

    class MyThread implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public MyThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500);
                cyclicBarrier.await();
                System.out.println("cyclicBarrier release");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            run(cyclicBarrier);
        }

        System.out.println(System.currentTimeMillis() - startTime);
        Thread.sleep(2000);
    }

    private void run(CyclicBarrier cyclicBarrier) {
        new Thread(new MyThread(cyclicBarrier)).start();
    }
}
