package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeMultiList {

    public ListNode merge(List<ListNode> lists) {
        ListNode head = new ListNode(0), node = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        queue.addAll(lists);
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            node.next = poll;
            node = node.next;
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return head.next;
    }
}
