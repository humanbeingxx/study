package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 15:30
 */
public class ReverseListTest {

    @Test
    public void testReverseList1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result = new ReverseList().reverseList(head);
        show(result);
    }

    @Test
    public void testReverseList2() {
        ListNode head = new ListNode(1, null);
        ListNode result = new ReverseList().reverseList(head);
        show(result);
    }

    @Test
    public void testReverseList3() {
        ListNode head = null;
        ListNode result = new ReverseList().reverseList(head);
        show(result);
    }

    private void show(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        show(node.next);
    }
}