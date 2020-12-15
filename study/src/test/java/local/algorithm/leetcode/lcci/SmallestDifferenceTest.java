package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class SmallestDifferenceTest {

    @Test
    public void testSmallestDifference1() {
        int result = new SmallestDifference().smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8});
        assertEquals(result, 3);
    }

    @Test
    public void testSmallestDifference2() {
        int result = new SmallestDifference().smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0});
        assertEquals(result, 1);
    }

    @Test
    public void testSmallestDifference3() {
        int result = new SmallestDifference().smallestDifference(new int[]{-1}, new int[]{2147483647});
        assertEquals(result, -2147483648);
    }

    @Test
    public void testSmallestDifference4() {
        int result = new SmallestDifference().smallestDifference(new int[]{1, 2, 11, 15}, new int[]{4, 12, 19, 23, 127, 235});
        assertEquals(result, 1);
    }


    @Test
    public void testSmallestDifferenceRandom() {
        int[] data1 = new int[10000];
        int[] data2 = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            data1[i] = random.nextInt(100);
            data2[i] = random.nextInt(100);
        }
        SmallestDifference func = new SmallestDifference();
        int result = func.smallestDifference(data1, data2);
        assertEquals(result, func.force(data1, data2));
    }

}