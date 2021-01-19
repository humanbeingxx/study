package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinCostConnectPointsTest {

    @Test
    public void testMinCostConnectPoints1() {
        int result = new MinCostConnectPoints().minCostConnectPoints(new int[][]{
                {2, -3}, {-17, -8}, {13, 8}, {-17, -15}
        });
        assertEquals(result, 53);
    }
}