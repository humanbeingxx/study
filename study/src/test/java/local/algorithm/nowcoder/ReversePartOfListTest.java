package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReversePartOfListTest {

    @Test
    public void testReverse1() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = new ReversePartOfList().reverse(head, node1, node4);
        System.out.println(reverse.show());
    }

    @Test
    public void testReverse2() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = new ReversePartOfList().reverse(head, head, node5);
        System.out.println(reverse.show());
    }

    @Test
    public void testReverse3() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = new ReversePartOfList().reverse(head, node1, node5);
        System.out.println(reverse.show());
    }
}