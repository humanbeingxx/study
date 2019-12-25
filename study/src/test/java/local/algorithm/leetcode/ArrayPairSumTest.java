package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class ArrayPairSumTest {

    @Test
    public void testArrayPairSum() {
        int result = new ArrayPairSum().arrayPairSum(new int[]{});
        Assert.assertEquals(result, 0);
    }
}