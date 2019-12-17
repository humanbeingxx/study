package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class ListMiddleNodeTest {

    @Test
    public void testMiddleNode1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = new ListMiddleNode().middleNode(head);
        Assert.assertEquals(result.val, 3);
    }

    @Test
    public void testMiddleNode2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode result = new ListMiddleNode().middleNode(head);
        Assert.assertEquals(result.val, 4);
    }


    @Test
    public void testMiddleNode3() {
        ListNode head = new ListNode(1, null);
        ListNode result = new ListMiddleNode().middleNode(head);
        Assert.assertEquals(result.val, 1);
    }

}