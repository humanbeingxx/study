package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CountSubStringWithOneCharDiffTest {

    @Test
    public void testCountSubstrings1() {
        int result = new CountSubStringWithOneCharDiff().countSubstrings("aba", "baba");
        assertEquals(result, 6);
    }

    @Test
    public void testCountSubstrings2() {
        int result = new CountSubStringWithOneCharDiff().countSubstringsBetter("aba", "baba");
        assertEquals(result, 6);
    }

    @Test
    public void testCountSubstrings3() {
        int result = new CountSubStringWithOneCharDiff().countSubstringsBetter("aba", "babaaabbababbaabb");
        assertEquals(result, 44);
    }
}