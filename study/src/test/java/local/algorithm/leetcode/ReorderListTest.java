package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class ReorderListTest {

    @Test
    public void testReorderList() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new ReorderList().reorderList(head);
        System.out.println(head.show());
    }
}