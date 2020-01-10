package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class ReverseListBetweenTest {

    @Test
    public void testReverse1() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode result = new ReverseListBetween().reverseK(node,2);
        System.out.println(result);
    }

    @Test
    public void testReverse2() {
        ListNode node = new ListNode(1, null);
        ListNode result = new ReverseListBetween().reverseK(node,2);
        System.out.println(result);
    }

    @Test
    public void testReverseBetween1() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode result = new ReverseListBetween().reverseBetween(node,2,3);
        System.out.println(result);
    }

    @Test
    public void testReverseBetween2() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode result = new ReverseListBetween().reverseBetween(node,1,4);
        System.out.println(result);
    }

    @Test
    public void testReverseBetween3() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode result = new ReverseListBetween().reverseBetween(node,3,3);
        System.out.println(result);
    }

    @Test
    public void testReverseBetween4() {
        ListNode node = new ListNode(1, null);
        ListNode result = new ReverseListBetween().reverseBetween(node,1,1);
        System.out.println(result);
    }
}