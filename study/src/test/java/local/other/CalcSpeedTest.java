package local.other;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CalcSpeedTest {

    @Test
    public void test() {
        List<Integer> result = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            if (i % 100 == i % 1000) {
                result.add(i);
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result.size());
    }
}
