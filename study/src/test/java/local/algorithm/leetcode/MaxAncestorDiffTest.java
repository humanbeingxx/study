package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxAncestorDiffTest {

    @Test
    public void testMaxAncestorDiff1() {
        TreeNode root = new TreeNode(2,
                null,
                new TreeNode(0,
                        null,
                        new TreeNode(4,
                                null,
                                new TreeNode(3,
                                        null,
                                        new TreeNode(1)))));
        int result = new MaxAncestorDiff().maxAncestorDiff(root);
        assertEquals(result, 4);
    }
}