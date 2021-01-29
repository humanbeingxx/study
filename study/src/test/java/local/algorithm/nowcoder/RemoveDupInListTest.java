package local.algorithm.nowcoder;

import local.algorithm.nowcoder.RemoveDupInList.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RemoveDupInListTest {

    @Test
    public void testRemoveDup1() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        head.next = node1;
        node1.pre = head;
        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        node3.next = node4;
        node4.pre = node3;
        new RemoveDupInList().removeDup(head);
        System.out.println(head);
    }
}