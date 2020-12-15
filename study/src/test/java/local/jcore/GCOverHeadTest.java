package local.jcore;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/10 1:37
 */
public class GCOverHeadTest {

    @Test
    public void overhead() {
        Properties properties = System.getProperties();
        Random random = new Random();
        while (true) {
            properties.put(random.nextInt(), "12345");
        }
    }

    @Test
    public void heapspace() {
        List<int[]> data = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            data.add(new int[100]);
        }
    }
}
