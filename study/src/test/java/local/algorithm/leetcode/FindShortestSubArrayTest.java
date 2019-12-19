package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class FindShortestSubArrayTest {

    @Test
    public void testFindShortestSubArray() {
        int result = new FindShortestSubArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1});
        Assert.assertEquals(result, 2);
        result = new FindShortestSubArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2});
        Assert.assertEquals(result, 6);
        result = new FindShortestSubArray().findShortestSubArray(new int[]{1, 2, 3});
        Assert.assertEquals(result, 1);
        result = new FindShortestSubArray().findShortestSubArray(new int[]{1, 2, 3, 3, 3});
        Assert.assertEquals(result, 3);
        result = new FindShortestSubArray().findShortestSubArray(new int[]{1});
        Assert.assertEquals(result, 1);
        result = new FindShortestSubArray().findShortestSubArray(new int[]{});
        Assert.assertEquals(result, 0);
    }

}