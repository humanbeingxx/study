package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxVowelsInSubTest {

    @Test
    public void testMaxVowels1() {
        int result = new MaxVowelsInSub().maxVowels("weallloveyou", 7);
        assertEquals(result, 4);
    }
}