package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxScoreSightseeingPairTest {

    @Test
    public void testMaxScoreSightseeingPair1() {
        int result = new MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
        assertEquals(result, 11);
    }

    @Test
    public void testMaxScoreSightseeingPair2() {
        int result = new MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{8, 1});
        assertEquals(result, 8);
    }
}