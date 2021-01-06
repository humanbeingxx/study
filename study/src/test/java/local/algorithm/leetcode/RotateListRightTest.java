package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class RotateListRightTest {

    @Test
    public void testRotateRight() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = new RotateListRight().rotateRight(head, 1);
        System.out.println(result.show());
    }
}