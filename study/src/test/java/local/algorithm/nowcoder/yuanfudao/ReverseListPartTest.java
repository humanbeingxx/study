package local.algorithm.nowcoder.yuanfudao;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReverseListPartTest {

    @Test
    public void testReverse1() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode result = new ReverseListPart().reverse(head, 3, 5);
        System.out.println(result.show());
    }

    @Test
    public void testReverse2() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode result = new ReverseListPart().reverse(head, 0, 5);
        System.out.println(result.show());
    }

    @Test
    public void testReverse3() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode result = new ReverseListPart().reverse(head, 0, 3);
        System.out.println(result.show());
    }

    @Test
    public void testReverse4() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode result = new ReverseListPart().reverse(head, 1, 2);
        System.out.println(result.show());
    }

    @Test
    public void testReverse5() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode result = new ReverseListPart().reverse(head, 6, 8);
        System.out.println(result.show());
    }

    @Test
    public void testReverse6() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        ListNode result = new ReverseListPart().reverse(head, 3, 9);
        System.out.println(result.show());
    }
}