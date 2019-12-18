package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 21:57
 */
public class NumPairsDivisibleBy60Test {

    @Test
    public void testNumPairsDivisibleBy60() {
        int result = new NumPairsDivisibleBy60().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        Assert.assertEquals(result, 3);

        result = new NumPairsDivisibleBy60().numPairsDivisibleBy60(new int[]{60,60,60});
        Assert.assertEquals(result, 3);

        result = new NumPairsDivisibleBy60().numPairsDivisibleBy60(new int[]{60});
        Assert.assertEquals(result, 0);

        result = new NumPairsDivisibleBy60().numPairsDivisibleBy60(new int[]{30, 30});
        Assert.assertEquals(result, 1);
    }
}