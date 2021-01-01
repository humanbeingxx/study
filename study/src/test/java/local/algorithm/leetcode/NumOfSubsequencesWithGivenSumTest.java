package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumOfSubsequencesWithGivenSumTest {

    @Test
    public void testNumSubseq1() {
        int result = new NumOfSubsequencesWithGivenSum().numSubseq(new int[]{3, 5, 6, 7}, 9);
        assertEquals(result, 4);
    }

    @Test
    public void testNumSubseq2() {
        int result = new NumOfSubsequencesWithGivenSum().numSubseq(new int[]{3, 3, 6, 8}, 10);
        assertEquals(result, 6);
    }

    @Test
    public void testNumSubseq3() {
        int result = new NumOfSubsequencesWithGivenSum().numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12);
        assertEquals(result, 61);
    }
}