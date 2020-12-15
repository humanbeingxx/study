package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class MinimumDifferenceTest {

    @Test
    public void testGetMinimumDifference() {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        null));
        int result = new MinimumDifference().getMinimumDifference(root);
        Assert.assertEquals(result, 1);
    }
}