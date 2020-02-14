package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-14
 **/
public class SortLinkedListTest {

    @Test
    public void testMerge() {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(4));
        ListNode result = new SortLinkedList().merge(l1, l2);
        System.out.println(result.show());
    }

    @Test
    public void testSortList() {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4)))));
        ListNode result = new SortLinkedList().sortList(head);
        System.out.println(result.show());
    }
}