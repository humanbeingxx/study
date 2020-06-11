package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static local.algorithm.leetcode.BinaryTreeHasPathSum.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/8 15:35
 */
public class ListOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        List<ListNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        ListNode head = null, node = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (head == null) {
                    head = new ListNode(treeNode.val);
                    node = head;
                } else {
                    node.next = new ListNode(treeNode.val);
                    node = node.next;
                }
                if (treeNode.left!= null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(head);
            head = null;
        }
        return result.toArray(new ListNode[0]);
    }
}
