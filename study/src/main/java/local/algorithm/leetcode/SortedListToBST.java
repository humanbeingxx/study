package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        int[] list = toArray(head);
        return rec(list, 0, list.length - 1);
    }

    private int[] toArray(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        int[] array = new int[len];
        int index = 0;
        node = head;
        while (node != null) {
            array[index++] = node.val;
            node = node.next;
        }
        return array;
    }

    private TreeNode rec(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int pos = (low + high) / 2;
        TreeNode node = new TreeNode(nums[pos], null, null);
        node.left = rec(nums, low, pos - 1);
        node.right = rec(nums, pos + 1, high);
        return node;
    }
}
