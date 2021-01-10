package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ConstructDistancedSequenceTest {

    @Test
    public void testConstructDistancedSequence1() {
        int[] result = new ConstructDistancedSequence().constructDistancedSequence(3);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testConstructDistancedSequence2() {
        int[] result = new ConstructDistancedSequence().constructDistancedSequence(15);
        Assert.assertEquals(result, new int[]{15, 13, 14, 10, 8, 12, 5, 3, 11, 9, 3, 5, 8, 10, 13,
                15, 14, 12, 9, 11, 7, 4, 6, 1, 2, 4, 2, 7, 6});
    }

    @Test
    public void testConstructDistancedSequence3() {
        int[] result = new ConstructDistancedSequence().constructDistancedSequence(20);
        Assert.assertEquals(result, new int[]{20, 18, 19, 15, 13, 17, 10, 16, 7, 5, 3, 14, 12, 3, 5, 7, 10, 13, 15, 18,
                20, 19, 17, 16, 12, 14, 11, 9, 4, 6, 8, 2, 4, 2, 1, 6, 9, 11, 8});
    }
}