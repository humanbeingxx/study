package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class CousinsInTreeTest {

    @Test
    public void testIsCousins1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3));
        boolean result = new CousinsInTree().isCousins(root, 4, 3);
        assertFalse(result);
    }

    @Test
    public void testIsCousins2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4)),
                new TreeNode(3,
                        null,
                        new TreeNode(5)));
        boolean result = new CousinsInTree().isCousins(root, 4, 3);
        assertFalse(result);

        result = new CousinsInTree().isCousins(root, 4, 5);
        assertTrue(result);


        result = new CousinsInTree().isCousins(root, 3, 2);
        assertFalse(result);
    }
}