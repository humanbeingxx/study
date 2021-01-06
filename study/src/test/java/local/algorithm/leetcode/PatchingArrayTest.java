package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PatchingArrayTest {

    @Test
    public void testMinPatches1() {
        int result = new PatchingArray().minPatches(new int[]{1, 3}, 6);
        assertEquals(result, 1);
    }

    @Test
    public void testMinPatches2() {
        int result = new PatchingArray().minPatches(new int[]{1, 5, 10}, 20);
        assertEquals(result, 2);
    }

    @Test
    public void testMinPatches3() {
        int result = new PatchingArray().minPatches(new int[]{1, 2, 2}, 5);
        assertEquals(result, 0);
    }
}