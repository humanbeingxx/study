package local.algorithm.leetcode;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class NumArrayTest {

    @Test
    public void testSumRange() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        int result = numArray.sumRange(0, 2);
        Assert.assertEquals(result, 1);

        result = numArray.sumRange(1, 3);
        Assert.assertEquals(result, -2);
    }
}