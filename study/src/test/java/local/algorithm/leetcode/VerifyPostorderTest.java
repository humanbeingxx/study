package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/5 15:42
 */
public class VerifyPostorderTest {

    @Test
    public void testVerifyPostorder1() {
        boolean result = new VerifyPostorder().verifyPostorder(new int[]{1, 6, 3, 2, 5});
        assertFalse(result);
    }

    @Test
    public void testVerifyPostorder2() {
        boolean result = new VerifyPostorder().verifyPostorder(new int[]{1, 3, 2, 6, 5});
        assertTrue(result);
    }

    @Test
    public void testVerifyPostorder3() {
        boolean result = new VerifyPostorder().verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3});
        assertFalse(result);
    }

    @Test
    public void testVerifyPostorder4() {
        boolean result = new VerifyPostorder().verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61});
        assertFalse(result);
    }
}