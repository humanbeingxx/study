package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static local.algorithm.leetcode.BinaryTreeHasPathSum.*;
import static org.testng.Assert.*;

public class IsSubPathInTreeTest {

    TreeNode root = new TreeNode(1,
            new TreeNode(4,
                    null,
                    new TreeNode(2,
                            new TreeNode(1),
                            null)),
            new TreeNode(4,
                    new TreeNode(2,
                            new TreeNode(6),
                            new TreeNode(8,
                                    new TreeNode(1),
                                    new TreeNode(3))),
                    null));

    @Test
    public void testIsSubPath1() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6, new ListNode(8)))));
        boolean result = new IsSubPathInTree().isSubPath(head, root);
        assertFalse(result);
    }

    @Test
    public void testIsSubPath2() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6))));
        boolean result = new IsSubPathInTree().isSubPath(head, root);
        assertTrue(result);
    }
}