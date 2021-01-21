package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void testReverse1() {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(new ReverseLinkedList().reverse(list).show());
    }

}