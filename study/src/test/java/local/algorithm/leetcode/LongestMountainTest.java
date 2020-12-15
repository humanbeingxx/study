package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestMountainTest {

    @Test
    public void testLongestMountain1() {
        int result = new LongestMountain().longestMountain(new int[]{1, 2, 5, 4, 3});
        assertEquals(result, 5);
    }

    @Test
    public void testLongestMountain2() {
        int result = new LongestMountain().longestMountain(new int[]{1, 2, 3, 4});
        assertEquals(result, 0);
        result = new LongestMountain().longestMountain(new int[]{4, 3, 2, 1});
        assertEquals(result, 0);
    }

    @Test
    public void testLongestMountain3() {
        int result = new LongestMountain().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5});
        assertEquals(result, 5);
    }

    @Test
    public void testLongestMountain4() {
        int result = new LongestMountain().longestMountain(new int[]{1, 2, 5, 4, 3, 4, 5, 6, 10, 9, 8, 7, 5, 6, 7, 10, 8, 9});
        assertEquals(result, 9);
    }

    @Test
    public void testLongestMountain5() {
        int result = new LongestMountain().longestMountain(new int[]{2,3,3,2,0,2});
        assertEquals(result, 0);
    }

    @Test
    public void testLongestMountain6() {
        int result = new LongestMountain().longestMountain(new int[]{1,2,5,4,3,3});
        assertEquals(result, 5);
    }


}