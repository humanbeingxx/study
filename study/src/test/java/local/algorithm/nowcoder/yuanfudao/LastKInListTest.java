package local.algorithm.nowcoder.yuanfudao;

import local.algorithm.leetcode.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LastKInListTest {

    @Test
    public void testLastKWithRec() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        assertEquals(new LastKInList().lastKWithRec(head, 4).val, 3);
        assertEquals(new LastKInList().lastKWithRec(head, 1).val, 6);
        assertEquals(new LastKInList().lastKWithRec(head, 6).val, 1);
        assertNull(new LastKInList().lastKWithRec(head, 0));
    }
}