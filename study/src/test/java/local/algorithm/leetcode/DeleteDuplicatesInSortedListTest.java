package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class DeleteDuplicatesInSortedListTest {

    @Test
    public void testDeleteDuplicates1() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))));
        ListNode result = new DeleteDuplicatesInSortedList().deleteDuplicates(head);
        System.out.println(result);
    }

    @Test
    public void testDeleteDuplicates2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new DeleteDuplicatesInSortedList().deleteDuplicates(head);
        System.out.println(result.show());
    }

    @Test
    public void testDeleteDuplicates3() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4, new ListNode(4)))));
        ListNode result = new DeleteDuplicatesInSortedList().deleteDuplicates(head);
        System.out.println(result.show());
    }

    @Test
    public void testDeleteDuplicates4() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(4, new ListNode(5)))));
        ListNode result = new DeleteDuplicatesInSortedList().deleteDuplicates(head);
        System.out.println(result.show());
    }
}