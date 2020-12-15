package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/14 17:25
 */
public class NthUglyNumberTest {

    @Test
    public void testNthUglyNumber() {
        int res = new NthUglyNumber().nthUglyNumber(50);
        assertEquals(res, 243);
    }
}