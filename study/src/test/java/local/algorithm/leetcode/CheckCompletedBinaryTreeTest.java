package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckCompletedBinaryTreeTest {

    @Test
    public void testIsCompleteTree0() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        boolean result = new CheckCompletedBinaryTree().isCompleteTree(root);
        assertTrue(result);
    }

    @Test
    public void testIsCompleteTree1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null));
        boolean result = new CheckCompletedBinaryTree().isCompleteTree(root);
        assertTrue(result);
    }

    @Test
    public void testIsCompleteTree2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        new TreeNode(6)));
        boolean result = new CheckCompletedBinaryTree().isCompleteTree(root);
        assertFalse(result);
    }
}