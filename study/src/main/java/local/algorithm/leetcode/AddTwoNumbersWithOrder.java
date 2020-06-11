package local.algorithm.leetcode;

import java.util.Stack;

import static local.algorithm.leetcode.RemoveListElements.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/7 15:25
 */
public class AddTwoNumbersWithOrder {

    /**
     * 反向存放的，也就是个位排在链表首部。
     */
    public int addTwoNumbers(ListNode l1, ListNode l2) {
        int result = 0;
        ListNode node1 = l1, node2 = l2;
        int carry = 0, oneSum = 0, pos = 1;
        while (node1 != null && node2 != null) {
            oneSum = node1.val + node2.val + carry;
            result += oneSum % 10 * pos;
            carry = oneSum / 10;
            node1 = node1.next;
            node2 = node2.next;
            pos *= 10;
        }
        while (node1 != null) {
            oneSum = node1.val + carry;
            carry = oneSum / 10;
            result += oneSum % 10 * pos;
            node1 = node1.next;
            pos *= 10;
        }
        while (node2 != null) {
            oneSum = node2.val + carry;
            carry = oneSum / 10;
            result += oneSum % 10 * pos;
            node2 = node2.next;
            pos *= 10;
        }
        if (carry == 1) {
            result += pos;
        }
        return result;
    }

    public ListNode addTwoNumbersLowOrder(ListNode l1, ListNode l2) {
        ListNode node1 = l1, node2 = l2, l3 = null, node3 = null;
        int carry = 0, oneSum;
        while (node1 != null && node2 != null) {
            oneSum = node1.val + node2.val + carry;
            if (l3 == null) {
                l3 = new ListNode(oneSum % 10);
                node3 = l3;
            } else {
                node3.next = new ListNode(oneSum % 10);
                node3 = node3.next;
            }
            carry = oneSum / 10;
            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1 != null) {
            oneSum = node1.val + carry;
            carry = oneSum / 10;
            if (l3 == null) {
                l3 = new ListNode(oneSum % 10);
                node3 = l3;
            } else {
                node3.next = new ListNode(oneSum % 10);
                node3 = node3.next;
            }
            node1 = node1.next;
        }
        while (node2 != null) {
            oneSum = node2.val + carry;
            carry = oneSum / 10;
            if (l3 == null) {
                l3 = new ListNode(oneSum % 10);
                node3 = l3;
            } else {
                node3.next = new ListNode(oneSum % 10);
                node3 = node3.next;
            }
            node2 = node2.next;
        }
        if (carry == 1) {
            node3.next = new ListNode(1);
        }
        return l3;
    }

    public ListNode addTwoNumbersHighOrder(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>(), stack3 = new Stack<>();
        ListNode node1 = l1, node2 = l2;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        int oneSum, val1, val2, carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            val1 = stack1.pop();
            val2 = stack2.pop();
            oneSum = val1 + val2 + carry;
            carry = oneSum / 10;
            stack3.push(oneSum % 10);
        }
        while (!stack1.isEmpty()) {
            val1 = stack1.pop();
            oneSum = val1 + carry;
            carry = oneSum / 10;
            stack3.push(oneSum % 10);
        }
        while (!stack2.isEmpty()) {
            val2 = stack2.pop();
            oneSum = val2 + carry;
            carry = oneSum / 10;
            stack3.push(oneSum % 10);
        }
        if (carry == 1) {
            stack3.push(1);
        }
        ListNode l3 = null, node3 = null;
        while (!stack3.isEmpty()) {
            if (l3 == null) {
                l3 = new ListNode(stack3.pop());
                node3 = l3;
            } else {
                node3.next = new ListNode(stack3.pop());
                node3 = node3.next;
            }
        }
        return l3;
    }
}
