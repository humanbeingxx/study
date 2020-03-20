package local.other;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class DaemonThreadTest {

    @Test
    public void test() throws InterruptedException {
        Thread userThread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    System.out.println("user thread working");
                }
            }
        });

        Thread daemonThread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    System.out.println("user thread working");
                }
            }
        });
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(500);
                    System.out.println("user thread working");
                }
            }
        });

        Thread daemonThread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    System.out.println("daemon thread working");
                }
            }
        });
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
    }
}
