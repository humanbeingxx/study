package local.other;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class SyncClassObjectTest {

    static class A {

        @SneakyThrows
        private void byClass(String text) {
            synchronized (SyncClassObjectTest.class) {
                System.out.println(text + " at " + System.currentTimeMillis());
                Thread.sleep(1000);
            }
        }

        @SneakyThrows
        private void byObject(String text) {
            synchronized (this) {
                System.out.println(text + " at " + System.currentTimeMillis());
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        A a1 = new A();
        A a2 = new A();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a1.byClass("thread1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a1.byClass("thread2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a1.byObject("thread3");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a1.byObject("thread4");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a2.byObject("thread5");
            }
        }).start();

        Thread.sleep(1500);
    }
}
