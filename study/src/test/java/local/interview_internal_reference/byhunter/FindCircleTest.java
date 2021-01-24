package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindCircleTest {

    @Test
    public void testFindCircle1() {
        ListNode enter = new ListNode(4, new ListNode(5, new ListNode(6)));
        enter.next.next.next = enter;
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, enter)));
        ListNode result = new FindCircle().findCircle(list);
        assertEquals(result.val, 4);
    }
}