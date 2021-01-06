package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindLongestPalindromeTest {

    @Test
    public void testLongestPalindrome1() {
        String result = new FindLongestPalindrome().longestPalindrome("babad");
        assertEquals(result, "bab");
    }

    @Test
    public void testLongestPalindrome2() {
        String result = new FindLongestPalindrome().longestPalindrome("cbbd");
        assertEquals(result, "bb");
    }

    @Test
    public void testLongestPalindrome3() {
        String result = new FindLongestPalindrome().longestPalindrome("aabbaa");
        assertEquals(result, "aabbaa");
    }

    @Test
    public void testLongestPalindrome4() {
        String result = new FindLongestPalindrome().longestPalindrome("ab");
        assertEquals(result, "a");
    }
}