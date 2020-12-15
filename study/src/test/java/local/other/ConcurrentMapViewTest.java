package local.other;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapViewTest {

    @Test
    public void test() throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
            }
        }).start();
        Thread.sleep(1);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Thread.sleep(100);
    }
}
