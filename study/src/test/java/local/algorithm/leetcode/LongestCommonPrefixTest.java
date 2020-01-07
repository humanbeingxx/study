package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix() {
        String result = new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assertEquals(result, "fl");

        result = new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        assertEquals(result, "");

    }
}