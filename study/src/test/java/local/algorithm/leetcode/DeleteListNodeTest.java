package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class DeleteListNodeTest {

    @Test
    public void testDeleteNode() {
        ListNode toDelete = new ListNode(5, new ListNode(1, new ListNode(2, null)));
        ListNode head = new ListNode(4, toDelete);
        new DeleteListNode().deleteNode(toDelete);
        String result = show(head);
        assertEquals(result, "4,1,2");

    }

    private String show(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        return sb.length() > 1 ? sb.deleteCharAt(sb.length() - 1).toString() : sb.toString();
    }
}