package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-14
 **/
public class AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbers() {
        //(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(result.show());
    }
}