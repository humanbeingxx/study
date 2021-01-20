package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxProductTreeTest {

    @Test
    public void testMaxProduct1() {
        TreeNode root = new TreeNode(1, new TreeNode(2),null);
        int result = new MaxProductTree().maxProduct(root);
        assertEquals(result, 2);
    }
}