package local.reservoir;

import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ReservoirSampleTest {

    private BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(10000);

    private Thread fillThread;

    @Before
    public void setUp() throws Exception {
        fillThread = new Thread(() -> {
            int initValue = 1;
            while (true) {
                try {
                    queue.put(initValue++);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        fillThread.start();
    }

    @After
    public void tearDown() throws Exception {
        fillThread.interrupt();
    }

    @Test
    public void testSample() throws InterruptedException {
        ReservoirSample reservoirSample = new ReservoirSample(20, queue);
        reservoirSample.init();
        reservoirSample.receive();
        Thread.sleep(1000);
        ImmutableList<Integer> result = reservoirSample.getResult();
        System.out.println(result);

        Thread.sleep(3000);
    }

}