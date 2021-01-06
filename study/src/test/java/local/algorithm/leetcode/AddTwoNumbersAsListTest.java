package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static local.algorithm.leetcode.RemoveListElements.ListNode;
import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class AddTwoNumbersAsListTest {

    @Test
    public void testAddTwoNumbers1() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode result = new AddTwoNumbersAsList().addTwoNumbers(l1, l2);
        assertEquals(result.show(), "708");
    }

    @Test
    public void testAddTwoNumbers2() {
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode result = new AddTwoNumbersAsList().addTwoNumbers(null, l2);
        assertEquals(result.show(), "564");
    }

    @Test
    public void testAddTwoNumbers3() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode result = new AddTwoNumbersAsList().addTwoNumbers(l1, null);
        assertEquals(result.show(), "243");
    }

    @Test
    public void testAddTwoNumbers4() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode result = new AddTwoNumbersAsList().addTwoNumbers(l1, l2);
        assertEquals(result.show(), "01");
    }
}