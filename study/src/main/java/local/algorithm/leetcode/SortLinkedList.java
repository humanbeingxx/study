package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-14
 **/
public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> partitions = new ArrayList<>();
        List<ListNode> temp = new ArrayList<>();

        ListNode node = head, next;
        while (node != null) {
            partitions.add(node);
            next = node.next;
            node.next = null;
            node = next;
        }
        while (partitions.size() > 1) {
            int index = 0;
            for (; index + 1 < partitions.size(); index += 2) {
                ListNode merged = merge(partitions.get(index), partitions.get(index + 1));
                temp.add(merged);
            }
            if (index == partitions.size() - 1) {
                temp.add(partitions.get(partitions.size() - 1));
            }

            partitions.clear();
            partitions.addAll(temp);
            temp.clear();
        }


        return partitions.get(0);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0), node = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }

        return head.next;
    }
}
