package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class PalindromeListTest {

    @Test
    public void testIsPalindrome1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
        boolean result = new PalindromeList().isPalindrome(head);
        assertTrue(result);
    }

    @Test
    public void testIsPalindrome2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, null)))));
        boolean result = new PalindromeList().isPalindrome(head);
        assertTrue(result);
    }

    @Test
    public void testIsPalindrome3() {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(1, null))));
        boolean result = new PalindromeList().isPalindrome(head);
        assertFalse(result);
    }

    @Test
    public void testIsPalindrome4() {
        ListNode head = new ListNode(1, new ListNode(3, null));
        boolean result = new PalindromeList().isPalindrome(head);
        assertFalse(result);
    }

    @Test
    public void testIsPalindrome5() {
        ListNode head = new ListNode(1, new ListNode(1, null));
        boolean result = new PalindromeList().isPalindrome(head);
        assertTrue(result);
    }

    @Test
    public void testIsPalindrome6() {
        ListNode head = new ListNode(1, null);
        boolean result = new PalindromeList().isPalindrome(head);
        assertTrue(result);
    }
}