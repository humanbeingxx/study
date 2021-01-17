package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GrumpyBookstoreOwnerTest {

    @Test
    public void testMaxSatisfied1() {
        int result = new GrumpyBookstoreOwner().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
        assertEquals(result, 16);
    }

    @Test
    public void testMaxSatisfied2() {
        int result = new GrumpyBookstoreOwner().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
        assertEquals(result, 16);
    }
}