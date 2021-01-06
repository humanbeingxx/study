package local.interview_internal_reference.bytecode;

import local.algorithm.ListNode;
import org.testng.annotations.Test;

public class ListGroupReverseTest {

    @Test
    public void testReverse1() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode reversed = ListGroupReverse.reverse(head, 1);
        System.out.println(reversed.display());
    }

    @Test
    public void testReverse2() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode reversed = ListGroupReverse.reverse(head, 2);
        System.out.println(reversed.display());
    }

    @Test
    public void testReverse3() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode reversed = ListGroupReverse.reverse(head, 3);
        System.out.println(reversed.display());
    }
}