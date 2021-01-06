package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class SplitArrayIntoThreeTest {

    @Test
    public void testWaysToSplit1() {
        int result = new SplitArrayIntoThree().waysToSplit(new int[]{1, 1, 1});
        assertEquals(result, 1);
    }

    @Test
    public void testWaysToSplit2() {
        int result = new SplitArrayIntoThree().waysToSplit(new int[]{3, 2, 1});
        assertEquals(result, 0);
    }

    @Test
    public void testWaysToSplit3() {
        int result = new SplitArrayIntoThree().waysToSplit(new int[]{1, 2, 2, 2, 5, 0});
        assertEquals(result, 3);
    }

    @Test
    public void testWaysToSplit4() {
        int result = new SplitArrayIntoThree().waysToSplit(new int[]{0, 0, 0, 0, 0});
        assertEquals(result, 6);
    }

    @Test
    public void testWaysToSplitRandom() {
        int[] data = new int[100];
        Random random = new Random();
        SplitArrayIntoThree func = new SplitArrayIntoThree();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100; j++) {
                data[j] = random.nextInt(10);
            }
            assertEquals(func.waysToSplit(data), func.waysToSplitForce(data));
        }
    }
}