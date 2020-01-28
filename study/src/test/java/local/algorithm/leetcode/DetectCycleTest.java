package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class DetectCycleTest {

    @Test
    public void testDetectCycle1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = new DetectCycle().detectCycle(head);
        assertNull(result);
    }

    @Test
    public void testDetectCycle2() {
        ListNode last = new ListNode(4);
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, last)));
        last.next = head;
        ListNode result = new DetectCycle().detectCycle(head);
        assertNotNull(result);
    }

    @Test
    public void testDetectCycle3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode result = new DetectCycle().detectCycle(node1);
        assertNotNull(result);
        assertSame(result, node2);
    }
}