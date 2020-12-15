package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 16:53
 */
public class WaysToChange2Test {

    @Test
    public void testWaysToChange1() {
        int result = new WaysToChange2().waysToChange(1000000);
        assertEquals(result, 332576607);
    }
}