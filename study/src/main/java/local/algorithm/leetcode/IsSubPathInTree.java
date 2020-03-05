package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import local.algorithm.leetcode.RemoveListElements.ListNode;

public class IsSubPathInTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return rec(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean rec(ListNode node, TreeNode root) {
        if (node == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return root.val == node.val && (rec(node.next, root.left) || rec(node.next, root.right));
    }
}
