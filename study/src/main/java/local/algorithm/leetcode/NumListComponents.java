package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-01
 **/
public class NumListComponents {

    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        boolean[] happenG = new boolean[10001];
        for (int i = 0; i < G.length; i++) {
            if (G[i] <= 10000) {
                happenG[G[i]] = true;
            }
        }
        int count = 0;
        ListNode node = head, next = head.next;
        while (true) {
            if (next == null) {
                if (happenG[node.val]) {
                    count++;
                }
                break;
            }

            if (happenG[node.val] && !happenG[next.val]) {
                count++;
            }
            node = next;
            next = node.next;
        }
        return count;
    }
}
