package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class NumberOfBoomerangsTest {

    @Test
    public void testNumberOfBoomerangs() {
        int result = new NumberOfBoomerangs().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        Assert.assertEquals(result, 2);
    }
}