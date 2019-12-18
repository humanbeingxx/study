package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class MatrixOperateCountTest {

    @Test
    public void testMaxCount() {
        int result = new MatrixOperateCount().maxCount(3, 3, new int[][]{{2, 2}, {3, 3}});
        Assert.assertEquals(result, 4);

        result = new MatrixOperateCount().maxCount(3, 3, new int[][]{{2, 2}, {3, 3}});
        Assert.assertEquals(result, 4);

        result = new MatrixOperateCount().maxCount(3, 3, new int[][]{{1, 1}});
        Assert.assertEquals(result, 1);


        result = new MatrixOperateCount().maxCount(3, 3, new int[][]{{1, 3}, {3, 1}});
        Assert.assertEquals(result, 1);

        result = new MatrixOperateCount().maxCount(3, 3, new int[][]{{3, 2}, {2, 3}});
        Assert.assertEquals(result, 4);

        result = new MatrixOperateCount().maxCount(10, 10, new int[][]{{2, 10}, {10, 2}});
        Assert.assertEquals(result, 4);
    }
}