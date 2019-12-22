package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/23 1:15
 */
public class GcdOfStringsTest {

    @Test
    public void testGcdOfStrings() {
        String result = new GcdOfStrings().gcdOfStrings("abcabc", "abc");
        assertEquals(result, "abc");

        result = new GcdOfStrings().gcdOfStrings("aaaaa", "aaaaa");
        assertEquals(result, "aaaaa");

        result = new GcdOfStrings().gcdOfStrings("ababab", "abab");
        assertEquals(result, "ab");

        result = new GcdOfStrings().gcdOfStrings("leet", "code");
        assertEquals(result, "");
    }
}