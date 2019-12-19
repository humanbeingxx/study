package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ListIntersectionNodeTest {

    @Test
    public void testGetIntersectionNode1() {
        ListNode same = new ListNode(10, new ListNode(11, new ListNode(12, null)));
        ListNode headA = new ListNode(1, new ListNode(2, same));
        ListNode headB = new ListNode(3, new ListNode(4, new ListNode(5, same)));
        ListNode result = new ListIntersectionNode().getIntersectionNode(headA, headB);
        Assert.assertEquals(result, same);
    }

    @Test
    public void testGetIntersectionNode2() {
//        ListNode same = new ListNode(10, new ListNode(11, new ListNode(12, null)));
        ListNode headA = new ListNode(1, new ListNode(2, null));
        ListNode headB = new ListNode(3, new ListNode(4, new ListNode(5, null)));
        ListNode result = new ListIntersectionNode().getIntersectionNode(headA, headB);
        Assert.assertNull(result);
    }

    @Test
    public void testGetIntersectionNode3() {
        ListNode same = new ListNode(2, new ListNode(4, null));
        ListNode headA = new ListNode(0, new ListNode(9, new ListNode(1, same)));
        ListNode headB = new ListNode(3, same);
        ListNode result = new ListIntersectionNode().getIntersectionNode(headA, headB);
        Assert.assertEquals(result, same);
    }

    @Test
    public void testGetIntersectionNode4() {
        ListNode headA = new ListNode(1, new ListNode(2, null));
        ListNode headB = new ListNode(3, null);
        ListNode result = new ListIntersectionNode().getIntersectionNode(headA, headB);
        Assert.assertNull(result);
    }
}