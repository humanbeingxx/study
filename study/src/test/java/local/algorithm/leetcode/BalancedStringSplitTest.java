package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 22:29
 */
public class BalancedStringSplitTest {

    @Test
    public void testBalancedStringSplit() {
        int result = new BalancedStringSplit().balancedStringSplit("RLRRLLRLRL");
        assertEquals(result, 4);

        result = new BalancedStringSplit().balancedStringSplit("LLLLRRRR");
        assertEquals(result, 1);
    }
}