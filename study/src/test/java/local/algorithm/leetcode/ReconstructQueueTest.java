package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2020-02-15
 **/
public class ReconstructQueueTest {

    @Test
    public void testReconstructQueue() {
        int[][] result = new ReconstructQueue().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}