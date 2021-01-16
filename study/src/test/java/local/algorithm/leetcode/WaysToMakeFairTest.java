package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaysToMakeFairTest {

    @Test
    public void testWaysToMakeFair1() {
        int result = new WaysToMakeFair().waysToMakeFair(new int[]{2, 1, 6, 4});
        assertEquals(result, 1);
    }

    @Test
    public void testWaysToMakeFair2() {
        int result = new WaysToMakeFair().waysToMakeFair(new int[]{1,1,1});
        assertEquals(result, 3);
    }

    @Test
    public void testWaysToMakeFair3() {
        int result = new WaysToMakeFair().waysToMakeFair(new int[]{1,2,3});
        assertEquals(result, 0);
    }
}