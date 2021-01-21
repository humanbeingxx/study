package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListAddOneTest {

    @Test
    public void testAdd1() {
        ListNode list = new ListNode(9, new ListNode(9));
        ListNode result = new LinkedListAddOne().add(list);
        System.out.println(result.show());
    }

    @Test
    public void testAdd2() {
        ListNode list = new ListNode(8, new ListNode(9));
        ListNode result = new LinkedListAddOne().add(list);
        System.out.println(result.show());
    }

    @Test
    public void testAdd3() {
        ListNode list = new ListNode(8, new ListNode(0, new ListNode(6, new ListNode(9))));
        ListNode result = new LinkedListAddOne().add(list);
        System.out.println(result.show());
    }

    @Test
    public void testAdd4() {
        ListNode list = new ListNode(8, new ListNode(0, new ListNode(6, new ListNode(6))));
        ListNode result = new LinkedListAddOne().add(list);
        System.out.println(result.show());
    }
}