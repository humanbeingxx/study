package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class ConstructRectangleTest {

    @Test
    public void testConstructRectangle() {
        int[] result = new ConstructRectangle().constructRectangle(4);
        Assert.assertEquals(result, new int[]{2, 2});

        result = new ConstructRectangle().constructRectangle(5);
        Assert.assertEquals(result, new int[]{5, 1});

        result = new ConstructRectangle().constructRectangle(6);
        Assert.assertEquals(result, new int[]{3, 2});

        result = new ConstructRectangle().constructRectangle(1);
        Assert.assertEquals(result, new int[]{1, 1});

    }
}