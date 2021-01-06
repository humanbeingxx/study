package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CuttingRopeIITest {

    @Test
    public void testCuttingRope1() {
        int result = new CuttingRopeII().cuttingRope(100);
        assertEquals(result, 703522804);
    }
}