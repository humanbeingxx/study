package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-21
 **/
public class InsertionSortListTest {

    @Test
    public void testInsertionSortList1() {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode result = new InsertionSortList().insertionSortList(head);
        System.out.println(result.show());
    }

    @Test
    public void testInsertionSortList2() {
        // -1->5->3->4->0
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode result = new InsertionSortList().insertionSortList(head);
        System.out.println(result.show());
    }

}