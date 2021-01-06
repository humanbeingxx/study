package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/5 16:58
 */
public class LengthOfLongestSubstring2Test {

    @Test
    public void testLengthOfLongestSubstring() {
        int result = new LengthOfLongestSubstring2().lengthOfLongestSubstring("abcabcabc");
        assertEquals(result, 3);

        result = new LengthOfLongestSubstring2().lengthOfLongestSubstring("bbbbb");
        assertEquals(result, 1);

        result = new LengthOfLongestSubstring2().lengthOfLongestSubstring("pwwkew");
        assertEquals(result, 3);

        result = new LengthOfLongestSubstring2().lengthOfLongestSubstring("dvdf");
        assertEquals(result, 3);
    }
}