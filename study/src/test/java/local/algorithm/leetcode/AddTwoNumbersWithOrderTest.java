package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/7 15:35
 */
public class AddTwoNumbersWithOrderTest {

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(7, new ListNode(1, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(9, new ListNode(6)));
        int result = new AddTwoNumbersWithOrder().addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    @Test
    public void testAddTwoNumbersLowOrder() {
        ListNode l1 = new ListNode(7, new ListNode(1, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(9, new ListNode(6)));
        ListNode l3 = new AddTwoNumbersWithOrder().addTwoNumbersLowOrder(l1, l2);
        System.out.println(l3.show());
    }

    @Test
    public void testBoundary() {
        ListNode l1 = null, l2 = null;

        int result = new AddTwoNumbersWithOrder().addTwoNumbers(l1, l2);
        assertEquals(result, 0);
        ListNode l3 = new AddTwoNumbersWithOrder().addTwoNumbersLowOrder(l1, l2);
        assertNull(l3);

        l1 = new ListNode(1);

        result = new AddTwoNumbersWithOrder().addTwoNumbers(l1, l2);
        assertEquals(result, 1);
        l3 = new AddTwoNumbersWithOrder().addTwoNumbersLowOrder(l1, l2);
        assertNotNull(l3);
    }

    @Test
    public void testAddTwoNumbersHighOrder() {
        ListNode l1 = new ListNode(6, new ListNode(1, new ListNode(7)));
        ListNode l2 = new ListNode(6, new ListNode(9, new ListNode(9)));
        ListNode l3 = new AddTwoNumbersWithOrder().addTwoNumbersHighOrder(l1, l2);
        System.out.println(l3.show());
    }
}