package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-15
 **/
public class LeastIntervalTest {

    @Test
    public void testLeastInterval() {
        int result = new LeastInterval().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        assertEquals(result, 8);
    }

    @Test
    public void testLeastInterval2() {
        int result = new LeastInterval().leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        assertEquals(result, 16);
    }

    @Test
    public void testLeastInterval3() {
        int result = new LeastInterval().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 50);
        assertEquals(result, 104);
    }
}