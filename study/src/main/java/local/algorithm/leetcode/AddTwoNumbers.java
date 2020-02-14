package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-02-14
 **/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> stackRes = new Stack<>();

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int remain = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            int sum = node1.val + node2.val + remain;
            stackRes.push(new ListNode(sum % 10));
            remain = sum / 10;
        }
        while (!stack1.isEmpty()) {
            ListNode node1 = stack1.pop();
            int sum = node1.val + remain;
            stackRes.push(new ListNode(sum % 10));
            remain = sum / 10;
        }
        while (!stack2.isEmpty()) {
            ListNode node2 = stack2.pop();
            int sum = node2.val + remain;
            stackRes.push(new ListNode(sum % 10));
            remain = sum / 10;
        }
        if (remain == 1) {
            stackRes.push(new ListNode(1));
        }
        ListNode node = stackRes.pop(), head = node;
        while (!stackRes.isEmpty()) {
            node.next = stackRes.pop();
            node = node.next;
        }
        return head;
    }
}
