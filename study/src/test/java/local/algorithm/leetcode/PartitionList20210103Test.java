package local.algorithm.leetcode;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PartitionList20210103Test {


    @Test
    public void testPartition1() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode result = new PartitionList20210103().partition(head, 3);
        System.out.println(result.show());
    }

    @Test
    public void testPartition2() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode result = new PartitionList20210103().partition(head, 1);
        System.out.println(result.show());
    }

    @Test
    public void testPartition3() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode result = new PartitionList20210103().partition(head, 7);
        System.out.println(result.show());
    }
}