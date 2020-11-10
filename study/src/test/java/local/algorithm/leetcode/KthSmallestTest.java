package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-23
 **/
public class KthSmallestTest {

    @Test
    public void testKthSmallest1() {
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));
        int result = new KthSmallest().kthSmallest(root, 1);
        assertEquals(result, 1);
    }

    @Test
    public void testKthSmallest2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6));
        int result = new KthSmallest().kthSmallest(root, 3);
        assertEquals(result, 3);
    }
}