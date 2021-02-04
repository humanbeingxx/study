package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckListHuiWenTest {

    @Test
    public void testCheck1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        boolean result = new CheckListHuiWen().check(head);
        assertTrue(result);
    }

    @Test
    public void testCheck2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(3, new ListNode(2, new ListNode(1))))));
        boolean result = new CheckListHuiWen().check(head);
        assertTrue(result);
    }

    @Test
    public void testCheck3() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(3, new ListNode(2, new ListNode(2))))));
        boolean result = new CheckListHuiWen().check(head);
        assertFalse(result);
    }

    @Test
    public void testCheck4() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(1)))));
        boolean result = new CheckListHuiWen().check(head);
        assertFalse(result);
    }
}