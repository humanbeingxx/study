package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class MaxSlidingWindowTest {

    @Test
    public void testMaxSlidingWindow1() {
        int[] result = new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testMaxSlidingWindow2() {
        int[] result = new MaxSlidingWindow().maxSlidingWindow(new int[]{7, 0, 6, 2, 3, 0, 9, 8, 4, 5, 0, 9, 2, 0, 9, 8, 2, 7, 5, 8, 8, 3, 1, 3, 3, 5, 1, 7, 2, 1}, 5);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testMaxSlidingWindowRandom() {
        int[] data = new int[30];
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            data[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(data));
        int[] result = new MaxSlidingWindow().maxSlidingWindow(data, 5);
        System.out.println(Arrays.toString(result));
    }
}