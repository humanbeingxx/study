package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ShortestSeqTest {

    @Test
    public void testShortestSeq1() {
        int[] result = new ShortestSeq().shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testShortestSeq2() {
        int[] result = new ShortestSeq().shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9, 8});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testShortestSeq3() {
        int[] result = new ShortestSeq().shortestSeq(new int[]{1, 2, 3}, new int[]{4});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testShortestSeq4() {
        int[] result = new ShortestSeq().shortestSeq(new int[]{4}, new int[]{4});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testShortestSeq5() {
        int[] result = new ShortestSeq().shortestSeq(new int[]{5, 5, 2, 1, 1, 1, 2, 2, 2, 2, 4, 5, 6, 7, 5, 4, 3, 2, 1}, new int[]{1, 2, 3});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testShortestSeq6() {
        int[] result = new ShortestSeq().shortestSeq(new int[]{521704, 897261, 279103, 381783, 668374, 934085, 254258, 726184, 496153, 804155},
                new int[]{897261, 934085, 381783, 496153});
        System.out.println(Arrays.toString(result));
    }
}