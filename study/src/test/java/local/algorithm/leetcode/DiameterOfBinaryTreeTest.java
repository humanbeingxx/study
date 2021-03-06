package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class DiameterOfBinaryTreeTest {

    @Test
    public void testDiameterOfBinaryTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        null));
        int result = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        Assert.assertEquals(result, 4);
    }
}