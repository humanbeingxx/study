package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class FindOverQuarterIntegerTest {

    @Test
    public void testFindSpecialInteger() {
        int result = new FindOverQuarterInteger().findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10});
        Assert.assertEquals(result, 6);

        result = new FindOverQuarterInteger().findSpecialInteger(new int[]{1, 2, 2, 2});
        Assert.assertEquals(result, 2);

        result = new FindOverQuarterInteger().findSpecialInteger(new int[]{1, 1, 1, 1, 1});
        Assert.assertEquals(result, 1);

        result = new FindOverQuarterInteger().findSpecialInteger(new int[]{1, 1});
        Assert.assertEquals(result, 1);
    }
}