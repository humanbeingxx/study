package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class PartitionListTest {

    @Test
    public void testPartition1() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode result = new PartitionList().partition(head, 3);
        System.out.println(result.show());
    }

    @Test
    public void testPartition2() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode result = new PartitionList().partition(head, 1);
        System.out.println(result.show());
    }

    @Test
    public void testPartition3() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode result = new PartitionList().partition(head, 7);
        System.out.println(result.show());
    }
}