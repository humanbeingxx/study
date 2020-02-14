package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-14
 **/
public class NextLargerNodesTest {

    @Test
    public void testNextLargerNodes1() {
        //2,7,4,3,5
        ListNode head = new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5)))));
        int[] result = new NextLargerNodes().nextLargerNodes(head);
        assertEquals(result, new int[]{7, 0, 5, 5, 0});
    }

    @Test
    public void testNextLargerNodes2() {
        //1,7,5,1,9,2,5,1
        ListNode head = new ListNode(1, new ListNode(7, new ListNode(5,
                new ListNode(1, new ListNode(9, new ListNode(2, new ListNode(5, new ListNode(1))))))));
        int[] result = new NextLargerNodes().nextLargerNodes(head);
        assertEquals(result, new int[]{7, 9, 9, 9, 0, 5, 0, 0});
    }
}