package local.algorithm;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/24 下午1:45
 **/
public class RulerTakeTest {

    @Test
    public void testTake() {
        Pair<Integer, Integer> result = RulerTake.take(new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}, 15);
        System.out.println(result);
    }

    @Test
    public void testTake2() {
        Pair<Integer, Integer> result = RulerTake.take(new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8, 15}, 15);
        System.out.println(result);
    }

    @Test
    public void testTakeNull() {
        Pair<Integer, Integer> result = RulerTake.take(new int[]{5}, 15);
        System.out.println(result);
    }

    @Test
    public void testTakeAll() {
        Pair<Integer, Integer> result = RulerTake.take(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 15);
        System.out.println(result);
    }
}