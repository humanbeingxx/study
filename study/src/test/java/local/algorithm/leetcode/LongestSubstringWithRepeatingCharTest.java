package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestSubstringWithRepeatingCharTest {

    @Test
    public void testLongestSubstring1() {
        int result = new LongestSubstringWithRepeatingChar().longestSubstring("aaabb", 3);
        assertEquals(result, 3);
    }

    @Test
    public void testLongestSubstring2() {
        int result = new LongestSubstringWithRepeatingChar().longestSubstring("ababbc", 2);
        assertEquals(result, 5);
    }

    @Test
    public void testLongestSubstring3() {
        int result = new LongestSubstringWithRepeatingChar().longestSubstring("ababcaabba", 2);
        assertEquals(result, 5);
    }

    @Test
    public void testLongestSubstring4() {
        int result = new LongestSubstringWithRepeatingChar().longestSubstring("ababcaabba", 3);
        assertEquals(result, 0);
    }

    @Test
    public void testLongestSubstring5() {
        int result = new LongestSubstringWithRepeatingChar().longestSubstring("bbaaacba", 3);
        assertEquals(result, 3);
    }
}