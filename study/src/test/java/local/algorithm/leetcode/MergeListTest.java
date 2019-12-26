package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/25 22:10
 */
public class MergeListTest {

    @Test
    public void testMergeTwoLists1() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode result = new MergeList().mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    @Test
    public void testMergeTwoLists2() {
        ListNode l1 = null;
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode result = new MergeList().mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}