package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestRepeatingCharacterReplacementBetterTest {

    @Test
    public void testCharacterReplacement0() {
        int result = new LongestRepeatingCharacterReplacementBetter().characterReplacement("AABABBA", 0);
        assertEquals(result, 2);
    }

    @Test
    public void testCharacterReplacement1() {
        int result = new LongestRepeatingCharacterReplacementBetter().characterReplacement("AABABBA", 1);
        assertEquals(result, 4);
    }

    @Test
    public void testCharacterReplacement2() {
        int result = new LongestRepeatingCharacterReplacementBetter().characterReplacement("ABAB", 2);
        assertEquals(result, 4);
    }

    @Test
    public void testCharacterReplacement3() {
        int result = new LongestRepeatingCharacterReplacementBetter().characterReplacement("ABABAAA", 1);
        assertEquals(result, 5);
    }

    @Test
    public void testCharacterReplacement4() {
        int result = new LongestRepeatingCharacterReplacementBetter().characterReplacement("AABB", 1);
        assertEquals(result, 3);
    }
}