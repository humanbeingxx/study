package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindKthPositiveTest {

    @Test
    public void testFindKthPositive1() {
        int result = new FindKthPositive().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
        assertEquals(result, 9);
    }

    @Test
    public void testFindKthPositive2() {
        int result = new FindKthPositive().findKthPositive(new int[]{1, 2, 3, 4}, 2);
        assertEquals(result, 6);
    }
}