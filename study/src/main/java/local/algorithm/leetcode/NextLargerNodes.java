package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-02-14
 **/
public class NextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        int[] result = new int[len];

        Stack<ListNode> stack = new Stack<>();
        Stack<Integer> indices = new Stack<>();
        int index = 0;
        node = head;
        stack.push(node);
        indices.push(index);
        node = node.next;
        index++;
        while (node != null) {
            while (true) {
                if (stack.isEmpty()) {
                    break;
                }
                ListNode peek = stack.peek();
                Integer topIndex = indices.peek();
                if (peek.val < node.val) {
                    result[topIndex] = node.val;
                    stack.pop();
                    indices.pop();
                } else {
                    break;
                }
            }
            stack.push(node);
            indices.push(index);
            index++;
            node = node.next;
        }
        return result;
    }
}
