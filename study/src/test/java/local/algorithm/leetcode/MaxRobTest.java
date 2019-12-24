package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class MaxRobTest {

    @Test
    public void testRob() {
        int result = new MaxRob().rob(new int[]{1, 2, 3, 1});
        Assert.assertEquals(result, 4);

        result = new MaxRob().rob(new int[]{2, 7, 9, 3, 1});
        Assert.assertEquals(result, 12);

        result = new MaxRob().rob(new int[]{1, 2});
        Assert.assertEquals(result, 2);


        result = new MaxRob().rob(new int[]{100, 1, 1, 200, 1});
        Assert.assertEquals(result, 300);
    }
}