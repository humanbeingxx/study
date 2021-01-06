package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class LargestNumberTest {

    @Test
    public void testLargestNumber1() {
        String result = new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9});
        Assert.assertEquals(result, "9534330");
    }

    @Test
    public void testLargestNumber2() {
        String result = new LargestNumber().largestNumber(new int[]{10, 2});
        Assert.assertEquals(result, "210");
    }

    @Test
    public void testLargestNumber3() {
        String result = new LargestNumber().largestNumber(new int[]{0, 0, 0, 0});
        Assert.assertEquals(result, "0");
    }
}