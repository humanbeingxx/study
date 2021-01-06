package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FindDuplicateSubtreesTest {

    @Test
    public void testFindDuplicateSubtrees1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(4),
                                null),
                        new TreeNode(4)));
        List<TreeNode> result = new FindDuplicateSubtrees().findDuplicateSubtrees(root);
        assertEquals(result.size(), 2);
    }

    @Test
    public void testFindDuplicateSubtrees2() {
        TreeNode root = new TreeNode(0,
                new TreeNode(0,
                        new TreeNode(0),
                        null),
                new TreeNode(0,
                        null,
                        new TreeNode(0,
                                null,
                                new TreeNode(0))));
        List<TreeNode> result = new FindDuplicateSubtrees().findDuplicateSubtrees(root);
        assertEquals(result.size(), 1);
    }
}