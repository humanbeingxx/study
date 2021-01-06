package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class LongestPalindromeTest {

    @Test
    public void testLongestPalindrome() {
        int result = new LongestPalindrome().longestPalindrome("abccccdd");
        assertEquals(result, 7);

        result = new LongestPalindrome().longestPalindrome("aabb");
        assertEquals(result, 4);
    }
}