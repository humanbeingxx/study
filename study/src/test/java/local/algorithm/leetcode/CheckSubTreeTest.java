package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class CheckSubTreeTest {

    @Test
    public void testIsSubtree() {
        TreeNode s = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1, null, null),
                        new TreeNode(2, null, null)),
                new TreeNode(5, null, null));
        TreeNode t = new TreeNode(4,
                new TreeNode(1, null, null),
                new TreeNode(2, null, null));
        boolean result = new CheckSubTree().isSubtree(s, t);
        Assert.assertTrue(result);
    }
}