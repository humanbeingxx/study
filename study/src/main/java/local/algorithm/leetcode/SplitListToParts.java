package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/13 0:03
 */
public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) {
            Arrays.fill(result, null);
            return result;
        }
        int len = 0;
        ListNode node = root;
        while (node != null) {
            node = node.next;
            len++;
        }
        int[] partLens = calLen(len, k);
        node = root;
        for (int i = 0; i < k; i++) {
            int partLen = partLens[i];
            result[i] = node;
            int j = 0;
            while (j < partLen - 1 && node != null) {
                j++;
                node = node.next;
            }
            if (node != null) {
                ListNode temp = node.next;
                node.next = null;
                node = temp;
            }
        }

        return result;
    }

    private int[] calLen(int len, int k) {
        int[] lens = new int[k];
        while (len > 0) {
            for (int i = 0; i < k && len > 0; i++) {
                lens[i]++;
                len--;
            }
        }
        return lens;
    }
}
