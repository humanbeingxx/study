package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class MinSumOfLengths1477Test {

    @Test
    public void testMinSumOfLengths1() {
        int result = new MinSumOfLengths1477().minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3);
        assertEquals(result, 3);
    }

    @Test
    public void testMinSumOfLengths2() {
        int result = new MinSumOfLengths1477().minSumOfLengths(new int[]{7,3,4,7}, 7);
        assertEquals(result, 2);
    }

    @Test
    public void testMinSumOfLengths3() {
        int result = new MinSumOfLengths1477().minSumOfLengths(new int[]{1,1,1,2,2,2,4,4}, 6);
        assertEquals(result, 6);
    }

    @Test
    public void testMinSumOfLengths4() {
        int result = new MinSumOfLengths1477().minSumOfLengths(new int[]{2,2,4,4,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 20);
        assertEquals(result, 23);
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(data));
        int result = new MinSumOfLengths1477().minSumOfLengths(data, 25);
        System.out.println(result);
    }
}