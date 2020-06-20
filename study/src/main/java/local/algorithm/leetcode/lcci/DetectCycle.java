package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 23:11
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode step1 = head, step2 = head;
        do {
            step1 = step1.next;
            if (step1 == null) {
                return null;
            }
            if (step2.next == null || step2.next.next == null) {
                return null;
            }
            step2 = step2.next.next;
        } while (step1 != step2);

        step2 = head;
        while (step1 != step2) {
            step1 = step1.next;
            step2 = step2.next;
        }
        return step1;
    }
}
