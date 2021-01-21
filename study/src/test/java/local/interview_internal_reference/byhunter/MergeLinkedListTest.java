package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

public class MergeLinkedListTest {

    @Test
    public void testMerge1() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode result = new MergeLinkedList().merge(list1, list2);
        System.out.println(result.show());
    }

    @Test
    public void testMerge2() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode list2 = new ListNode(0);
        ListNode result = new MergeLinkedList().merge(list1, list2);
        System.out.println(result.show());
    }
    @Test
    public void testMerge3() {
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode result = new MergeLinkedList().merge(list1, list2);
        System.out.println(result.show());
    }
    @Test
    public void testMerge4() {
        ListNode list1 = new ListNode(7, new ListNode(8, new ListNode(9)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode result = new MergeLinkedList().merge(list1, list2);
        System.out.println(result.show());
    }
}