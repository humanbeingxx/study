package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SumAbsoluteDifferencesTest {

    @Test
    public void testGetSumAbsoluteDifferences1() {
        int[] result = new SumAbsoluteDifferences().getSumAbsoluteDifferences(new int[]{1,4,6,8,10});
        assertEquals(result, new int[]{24,15,13,15,21});
    }

    @Test
    public void testGetSumAbsoluteDifferences2() {
        int[] result = new SumAbsoluteDifferences().getSumAbsoluteDifferences(new int[]{2,3,5});
        assertEquals(result, new int[]{4,3,5});
    }
}