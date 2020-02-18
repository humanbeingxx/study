package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class MinSubArrayLenTest {

    @Test
    public void testMinSubArrayLen1() {
        int result = new MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        assertEquals(result, 2);
    }


    @Test
    public void testMinSubArrayLen2() {
        int result = new MinSubArrayLen().minSubArrayLen(7, new int[]{1,2,3,4,5,6,7,8});
        assertEquals(result, 1);
    }
}