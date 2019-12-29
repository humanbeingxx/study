package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 22:19
 */
public class HeightCheckerTest {

    @Test
    public void testHeightChecker() {
        int result = new HeightChecker().heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        assertEquals(result, 3);
    }
}