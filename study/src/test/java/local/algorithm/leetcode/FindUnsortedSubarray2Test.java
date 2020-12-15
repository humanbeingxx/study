package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindUnsortedSubarray2Test {

    @Test
    public void testFindUnsortedSubarray() {
        assertEquals(new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}), 5);
        assertEquals(new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1, 2, 3, 4, 5}), 0);
        assertEquals(new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{3, 2, 1}), 3);
        assertEquals(new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1, 2}), 0);
        assertEquals(new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1}), 0);
        assertEquals(new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{}), 0);
    }

    @Test
    public void testFindUnsortedSubarray2() {
        int result = new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1, 3, 2, 2, 2, 2});
        assertEquals(result, 5);
    }

    @Test
    public void testFindUnsortedSubarray3() {
        int result = new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1, 1, 3, 3, 2, 2, 2});
        assertEquals(result, 5);
    }

    @Test
    public void testFindUnsortedSubarray4() {
        int result = new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1, 2, 3, 3, 3});
        assertEquals(result, 0);
    }

    @Test
    public void testFindUnsortedSubarray5() {
        int result = new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1, 3, 2});
        assertEquals(result, 2);
    }

    @Test
    public void testFindUnsortedSubarray6() {
        int result = new FindUnsortedSubarray2().findUnsortedSubarray(new int[]{1, 2, 4, 5, 3});
        assertEquals(result, 3);
    }
}