package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-01
 **/
public class WidthOfBinaryTreeTest {

    @Test
    public void testWidthOfBinaryTree1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5),
                        new TreeNode(3)),
                new TreeNode(2,
                        null,
                        new TreeNode(9)));
        int result = new WidthOfBinaryTree().widthOfBinaryTree(root);
        assertEquals(result, 4);
    }

    @Test
    public void testWidthOfBinaryTree2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(1,
                        new TreeNode(1,
                                new TreeNode(1),
                                null),
                        null),
                new TreeNode(1,
                        null,
                        new TreeNode(1,
                                null,
                                new TreeNode(1))));
        int result = new WidthOfBinaryTree().widthOfBinaryTree(root);
        assertEquals(result, 8);
    }
}