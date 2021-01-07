package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinOpReduceXToZeroTest {

    @Test
    public void testMinOperations1() {
        int result = new MinOpReduceXToZero().minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10);
        assertEquals(result, 5);
    }

    @Test
    public void testMinOperations2() {
        int result = new MinOpReduceXToZero().minOperations(new int[]{1, 1, 4, 2, 3}, 5);
        assertEquals(result, 2);
    }

    @Test
    public void testMinOperations3() {
        int result = new MinOpReduceXToZero().minOperations(new int[]{10, 1, 4, 2, 3}, 5);
        assertEquals(result, 2);
    }

    @Test
    public void testMinOperations4() {
        int result = new MinOpReduceXToZero().minOperations(new int[]{1, 4, 2, 30}, 5);
        assertEquals(result, 2);
    }

    @Test
    public void testMinOperations5() {
        int result = new MinOpReduceXToZero().minOperations(new int[]{5, 6, 7, 8, 9}, 10);
        assertEquals(result, -1);
    }

    @Test
    public void testMinOperations6() {
        int result = new MinOpReduceXToZero().minOperations(new int[]{1, 2, 3, 5, 5, 6}, 10);
        assertEquals(result, -1);
    }

    @Test
    public void testMinOperations7() {
        int result = new MinOpReduceXToZero().minOperations(new int[]{1,1}, 3);
        assertEquals(result, -1);
    }
}