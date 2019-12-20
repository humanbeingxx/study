package local.algorithm.leetcode;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class ContainsDuplicateTest {

    @Test
    public void testContainsDuplicate() {
        boolean result = new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 1});
        Assert.assertTrue(result);
        result = new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 4});
        Assert.assertFalse(result);
        result = new ContainsDuplicate().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        Assert.assertTrue(result);
    }
}