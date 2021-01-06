package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class SubarraysDivByKTest {

    @Test
    public void testSubarraysDivByK1() {
        int result = new SubarraysDivByK().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        assertEquals(result, 7);
    }

    @Test
    public void testSubarraysDivByK2() {
        int result = new SubarraysDivByK().subarraysDivByK(new int[]{4}, 5);
        assertEquals(result, 0);
    }

    @Test
    public void testRandom() {
        int[] data = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            data[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(data));
        int result = new SubarraysDivByK().subarraysDivByK(data, 3);
        System.out.println(result);
    }
}