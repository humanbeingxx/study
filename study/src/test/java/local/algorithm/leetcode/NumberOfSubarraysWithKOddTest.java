package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class NumberOfSubarraysWithKOddTest {

    @Test
    public void testNumberOfSubarrays1() {
        int result = new NumberOfSubarraysWithKOdd().numberOfSubarrays(new int[]{2, 2, 1, 2, 2}, 1);
        assertEquals(result, 9);
    }

    @Test
    public void testNumberOfSubarrays2() {
        int result = new NumberOfSubarraysWithKOdd().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
        assertEquals(result, 16);
    }

    @Test
    public void testNumberOfSubarrays3() {
        Random random = new Random();
        int[] data = new int[100];
        for (int i = 0; i < 100; i++) {
            data[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(data));
        int result = new NumberOfSubarraysWithKOdd().numberOfSubarrays(data, 3);
        assertEquals(result, 16);
    }
}