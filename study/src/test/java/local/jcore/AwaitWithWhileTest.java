package local.jcore;

import com.google.common.base.Preconditions;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class AwaitWithWhileTest {

    static class Buffer {
        int count;

        @SneakyThrows
        public synchronized void put() {
            count++;
            this.notifyAll();
        }

        @SneakyThrows
        public synchronized int take() {
            while (count <= 0) {
                this.wait();
                System.out.println("unlock " + count);
            }
//            if (count <= 0) {
//                this.wait();
//            }
            Thread.sleep(1000);
            Preconditions.checkState(count > 0);
            return count--;
        }
    }

    @Test
    public void test() throws InterruptedException {
        Buffer buffer = new Buffer();
        new Thread(() -> {
            System.out.println(buffer.take());
        }).start();

        new Thread(() -> {
            System.out.println(buffer.take());
        }).start();

        new Thread(() -> {
            System.out.println(buffer.take());
        }).start();

        Thread.sleep(20);
        new Thread(buffer::put).start();

        Thread.sleep(1500);
    }
}
