package local.algorithm.leetcode;

import org.testng.annotations.Test;
import local.algorithm.leetcode.MergeInBetweenLinkedLists.ListNode;

import static org.testng.Assert.*;

public class MergeInBetweenLinkedListsTest {

    @Test
    public void testMergeInBetween() {
        ListNode list1 = new ListNode(0,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6)))))));
        ListNode list2 = new ListNode(100,
                new ListNode(101,
                        new ListNode(102,
                                new ListNode(103))));
        ListNode result = new MergeInBetweenLinkedLists().mergeInBetween(list1, 3, 4, list2);
        System.out.println(result.print());
    }
}