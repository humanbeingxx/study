package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class LowestCommonAncestorTest {

    @Test
    public void testLowestCommonAncestor() {
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));
        TreeNode result = new LowestCommonAncestor().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        Assert.assertEquals(result.val, 6);

        result = new LowestCommonAncestor().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        Assert.assertEquals(result.val, 2);
    }
}