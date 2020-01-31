package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class MaskPIITest {

    @Test
    public void testMaskPII1() {
        String result = new MaskPII().maskPII("LeetCode@LeetCode.com");
        assertEquals(result, "l*****e@leetcode.com");
    }

    @Test
    public void testMaskPII2() {
        String result = new MaskPII().maskPII("LeetCode@LeetCode.");
        assertEquals(result, "");
    }

    @Test
    public void testMaskPII3() {
        String result = new MaskPII().maskPII("AB@qq.com");
        assertEquals(result, "a*****b@qq.com");
    }

    @Test
    public void testMaskPII5() {
        String result = new MaskPII().maskPII("1(234)567-890");
        assertEquals(result, "***-***-7890");
    }

    @Test
    public void testMaskPII6() {
        String result = new MaskPII().maskPII("86-(10)12345678");
        assertEquals(result, "+**-***-***-5678");
    }
}