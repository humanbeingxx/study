package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class LengthOfLongestSubstringTest {

    @Test
    public void testLengthOfLongestSubstring() {
        int result = new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcabc");
        assertEquals(result, 3);

        result = new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb");
        assertEquals(result, 1);

        result = new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
        assertEquals(result, 3);

        result = new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf");
        assertEquals(result, 3);
    }
}