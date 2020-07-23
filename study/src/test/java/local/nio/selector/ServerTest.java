package local.nio.selector;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/10 15:52
 */
public class ServerTest {

    @Test
    public void testWork() throws InterruptedException, IOException {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                new Server().work(8080);
            }
        }).start();

//        Thread.sleep(100);
//
//        new Client().work(8080);
//
//        Thread.sleep(100);
//
//        new Client().work(8080);

        Thread.sleep(1000000);

    }
}