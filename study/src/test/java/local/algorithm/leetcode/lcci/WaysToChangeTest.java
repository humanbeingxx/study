package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 16:53
 */
public class WaysToChangeTest {

    @Test
    public void testWaysToChange1() {
        int result = new WaysToChange().waysToChange(1000000);
        assertEquals(result, 332576607);
    }
}