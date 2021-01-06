package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberOfSubstringsABCTest {

    @Test
    public void testNumberOfSubstrings1() {
        int result = new NumberOfSubstringsABC().numberOfSubstrings("abcabc");
        assertEquals(result, 10);
    }
}