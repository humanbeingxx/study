package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 22:23
 */
public class RemoveListElementsTest {

    @Test
    public void testRemoveElements1() {
        RemoveListElements.ListNode head = new RemoveListElements.ListNode(1,
                new RemoveListElements.ListNode(1,
                        new RemoveListElements.ListNode(1,
                                new RemoveListElements.ListNode(1, null))));
        RemoveListElements.ListNode node = new RemoveListElements().removeElements(head, 1);
        Assert.assertNull(node);
    }

    @Test
    public void testRemoveElements2() {
        RemoveListElements.ListNode head = new RemoveListElements.ListNode(1,
                new RemoveListElements.ListNode(2,
                        new RemoveListElements.ListNode(6,
                                new RemoveListElements.ListNode(3,
                                        new RemoveListElements.ListNode(4,
                                                new RemoveListElements.ListNode(5,
                                                        new RemoveListElements.ListNode(6, null)))))));
        RemoveListElements.ListNode node = new RemoveListElements().removeElements(head, 6);
        Assert.assertEquals(node.val, 1);
        node = node.next;
        Assert.assertEquals(node.val, 2);
        node = node.next;
        Assert.assertEquals(node.val, 3);
        node = node.next;
        Assert.assertEquals(node.val, 4);
        node = node.next;
        Assert.assertEquals(node.val, 5);

    }

    @Test
    public void testRemoveElements3() {
        RemoveListElements.ListNode head = new RemoveListElements.ListNode(1,
                new RemoveListElements.ListNode(2,
                        new RemoveListElements.ListNode(3,
                                new RemoveListElements.ListNode(4,
                                        new RemoveListElements.ListNode(5, null)))));
        RemoveListElements.ListNode node = new RemoveListElements().removeElements(head, 6);
        Assert.assertEquals(node.val, 1);
        node = node.next;
        Assert.assertEquals(node.val, 2);
        node = node.next;
        Assert.assertEquals(node.val, 3);
        node = node.next;
        Assert.assertEquals(node.val, 4);
        node = node.next;
        Assert.assertEquals(node.val, 5);

    }

    @Test
    public void testRemoveElements4() {
        RemoveListElements.ListNode node = new RemoveListElements().removeElements(null, 6);
        Assert.assertNull(node);

    }

    @Test
    public void testRemoveElements5() {
        RemoveListElements.ListNode head = new RemoveListElements.ListNode(1, null);
        RemoveListElements.ListNode node = new RemoveListElements().removeElements(head, 0);
        Assert.assertEquals(node.val, 1);
    }
}