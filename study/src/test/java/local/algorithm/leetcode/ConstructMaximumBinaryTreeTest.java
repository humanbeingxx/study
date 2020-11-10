package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-23
 **/
public class ConstructMaximumBinaryTreeTest {

    @Test
    public void testConstructMaximumBinaryTree() {
        TreeNode root = new ConstructMaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(root);
    }
}