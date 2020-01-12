package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/13 0:06
 */
public class SplitListToPartsTest {

    @Test
    public void testSplitListToParts1() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode[] result = new SplitListToParts().splitListToParts(node, 3);
        Arrays.stream(result).forEach(e -> {
            System.out.println(e == null ? "" : e.show());
        });
    }

    @Test
    public void testSplitListToParts2() {
        ListNode node = new ListNode(1, new ListNode(2, null));
        ListNode[] result = new SplitListToParts().splitListToParts(node, 3);
        Arrays.stream(result).forEach(e -> {
            System.out.println(e == null ? "" : e.show());
        });
    }

    @Test
    public void testSplitListToParts3() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode[] result = new SplitListToParts().splitListToParts(node, 3);
        Arrays.stream(result).forEach(e -> {
            System.out.println(e == null ? "" : e.show());
        });
    }

    @Test
    public void testSplitListToParts4() {
        ListNode[] result = new SplitListToParts().splitListToParts(null, 3);
        Arrays.stream(result).forEach(e -> {
            System.out.println(e == null ? "" : e.show());
        });
    }

    @Test
    public void testSplitListToParts5() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, null)))))));

        ListNode[] result = new SplitListToParts().splitListToParts(node, 3);
        Arrays.stream(result).forEach(e -> {
            System.out.println(e == null ? "" : e.show());
        });
    }
}