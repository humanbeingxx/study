package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RemoveDupTest {

    @Test
    public void testRemoveDup1() {
        ListNode list = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))));
        System.out.println(new RemoveDup().removeDup(list).show());
    }

    @Test
    public void testRemoveDup2() {
        ListNode list = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2)))));
        System.out.println(new RemoveDup().removeDup(list).show());
    }

    @Test
    public void testRemoveDup3() {
        ListNode list = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))));
        System.out.println(new RemoveDup().removeDup(list).show());
    }

    @Test
    public void testRemoveDup4() {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new RemoveDup().removeDup(list).show());
    }
}