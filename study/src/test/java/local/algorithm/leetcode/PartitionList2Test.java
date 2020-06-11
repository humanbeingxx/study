package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/8 16:07
 */
public class PartitionList2Test {

    @Test
    public void testPartition1() {
        RemoveListElements.ListNode head = new RemoveListElements.ListNode(1, new RemoveListElements.ListNode(4, new RemoveListElements.ListNode(3, new RemoveListElements.ListNode(2, new RemoveListElements.ListNode(5, new RemoveListElements.ListNode(2, null))))));
        RemoveListElements.ListNode result = new PartitionList2().partition(head, 3);
        System.out.println(result.show());
        assertEquals(result.show(), "122435");
    }

    @Test
    public void testPartition2() {
        RemoveListElements.ListNode head = new RemoveListElements.ListNode(1, new RemoveListElements.ListNode(4, new RemoveListElements.ListNode(3, new RemoveListElements.ListNode(2, new RemoveListElements.ListNode(5, new RemoveListElements.ListNode(2, null))))));
        RemoveListElements.ListNode result = new PartitionList2().partition(head, 1);
        assertEquals(result.show(), "143252");
    }

    @Test
    public void testPartition3() {
        RemoveListElements.ListNode head = new RemoveListElements.ListNode(1, new RemoveListElements.ListNode(4, new RemoveListElements.ListNode(3, new RemoveListElements.ListNode(2, new RemoveListElements.ListNode(5, new RemoveListElements.ListNode(2, null))))));
        RemoveListElements.ListNode result = new PartitionList2().partition(head, 7);
        assertEquals(result.show(), "143252");
    }
}