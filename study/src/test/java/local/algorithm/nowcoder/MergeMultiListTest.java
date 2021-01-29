package local.algorithm.nowcoder;

import com.google.common.collect.Lists;
import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MergeMultiListTest {

    @Test
    public void testMerge() {
        ListNode list1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode list2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode list3 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = new MergeMultiList().merge(Lists.newArrayList(list1, list2, list3));
        System.out.println(result.show());
    }
}