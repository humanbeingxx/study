package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class NumSmallerByFrequencyTest {

    @Test
    public void testCount() {
        int result = new NumSmallerByFrequency().count("caaab");
        assertEquals(result, 3);
    }

    @Test
    public void testNumSmallerByFrequency() {
        int[] result = new NumSmallerByFrequency().numSmallerByFrequency(
                new String[]{"bbb", "cc"},
                new String[]{"a", "aa", "aaa", "aaaa"}
        );
        assertEquals(result, new int[]{1, 2});
    }
}