package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CuttingRopeTest {

    @Test
    public void testCuttingRope1() {
        int result = new CuttingRope().cuttingRope(10);
        assertEquals(result, 36);
    }

    @Test
    public void testCuttingRopeRandom() {
        for (int i = 0; i < 50; i++) {
            int n = i + 1;
            int result = new CuttingRope().cuttingRope(n);
            System.out.println(n + "\n" + result + "\n\n");
        }
    }
}