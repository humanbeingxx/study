package local.jcore;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-07-02
 **/
public class WaitNotifyTest {

    @Test
    public void testWait() throws InterruptedException {
        MyLock myLock = new MyLock(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start waiting");
                        myLock.await();
                        Thread.sleep(500);
                        System.out.println("finish waiting");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    myLock.success();
                    System.out.println("finish notification");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(2000);
    }

    @Test(expectedExceptions={IllegalStateException.class})
    public void testDeadLock() throws Exception {
        MyLock myLock = new MyLock(Thread.currentThread());
        myLock.await();
        myLock.success();
    }

    class MyLock {
        Thread thread;
        volatile boolean done = false;

        MyLock(Thread thread) {
            this.thread = thread;
        }

        void await() throws InterruptedException {
            if (thread == Thread.currentThread()) {
                throw new IllegalStateException("dead lock");
            }
            synchronized (this) {
                while (!done) {
                    this.wait();
                }
            }
        }

        void success() {
            synchronized (this) {
                this.notifyAll();
                done = true;
            }
        }
    }

    @Test
    public void testWaitTooLong() throws InterruptedException {
        new Thread(() -> {
            synchronized (this) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (this) {
                try {
                    Thread.sleep(200);
                    notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(2500);
    }
}
