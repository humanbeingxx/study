package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxScoreFromRemovingSubTest {

    @Test
    public void testMaximumGain() {
        int result = new MaxScoreFromRemovingSub().maximumGain("aabbabkbbb", 1, 2);
        assertEquals(result, 4);
    }
}