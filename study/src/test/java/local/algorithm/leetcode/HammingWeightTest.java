package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class HammingWeightTest {

    @Test
    public void testHammingWeight1() {
        int result = new HammingWeight().hammingWeight(0b0001);
        Assert.assertEquals(result, 1);
        result = new HammingWeight().hammingWeight(0b0011);
        Assert.assertEquals(result, 2);
        result = new HammingWeight().hammingWeight(0b0111);
        Assert.assertEquals(result, 3);
        result = new HammingWeight().hammingWeight(0b1111);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void testHammingWeight2() {
        int result = new HammingWeight().hammingWeight(Integer.MIN_VALUE);
        Assert.assertEquals(result, 1);
        result = new HammingWeight().hammingWeight(-1);
        Assert.assertEquals(result, 32);
        result = new HammingWeight().hammingWeight(Integer.MAX_VALUE);
        Assert.assertEquals(result, 31);
    }
}