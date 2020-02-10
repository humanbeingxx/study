package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-10
 **/
public class FlattenTreeTest {

    @Test
    public void testFlatten() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(7)));
        new FlattenTree().flatten(root);
        for (int i = 1; i <= 7; i++) {
            assertEquals(root.val, i);
            root = root.right;
        }
    }
}