package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinNumberOfFrogsTest {

    @Test
    public void testMinNumberOfFrogs1() {
        int result = new MinNumberOfFrogs().minNumberOfFrogs("croakcroak");
        assertEquals(result, 1);
    }

    @Test
    public void testMinNumberOfFrogs2() {
        int result = new MinNumberOfFrogs().minNumberOfFrogs("crcoakroak");
        assertEquals(result, 2);
    }

    @Test
    public void testMinNumberOfFrogs3() {
        int result = new MinNumberOfFrogs().minNumberOfFrogs("cccrrroooakacraokakk");
        assertEquals(result, 3);
    }
}