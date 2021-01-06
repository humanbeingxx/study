package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static local.algorithm.leetcode.RemoveListElements.ListNode;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class LinkedListCycleTest {

    @Test
    public void testHasCycle1() {
        ListNode start = new ListNode(2, new ListNode(0, null));
        ListNode head = new ListNode(3, start);
        start.next.next = new ListNode(-4, start);

        boolean result = new LinkedListCycle().hasCycle(head);
        assertTrue(result);
    }

    @Test
    public void testHasCycle2() {
        ListNode head = new ListNode(3, null);
        head.next = head;

        boolean result = new LinkedListCycle().hasCycle(head);
        assertTrue(result);
    }

    @Test
    public void testHasCycle3() {
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, head);

        boolean result = new LinkedListCycle().hasCycle(head);
        assertTrue(result);
    }

    @Test
    public void testHasCycle4() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

        boolean result = new LinkedListCycle().hasCycle(head);
        assertFalse(result);
    }
}