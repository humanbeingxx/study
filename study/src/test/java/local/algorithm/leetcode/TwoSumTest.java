package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class TwoSumTest {

    @Test
    public void testTwoSum() {
        int[] result = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(result, new int[]{1, 2});

    }
}