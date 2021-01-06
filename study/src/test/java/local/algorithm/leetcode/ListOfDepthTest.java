package local.algorithm.leetcode;

import local.algorithm.leetcode.RemoveListElements.ListNode;
import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/8 15:40
 */
public class ListOfDepthTest {

    @Test
    public void testListOfDepth1() {
        TreeNode tree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                null),
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        new TreeNode(7)));
        ListNode[] result = new ListOfDepth().listOfDepth(tree);
        for (ListNode listNode : result) {
            System.out.println(listNode.show());
        }
    }

    @Test
    public void testListOfDepth2() {
        TreeNode tree = new TreeNode(1);
        ListNode[] result = new ListOfDepth().listOfDepth(tree);
        for (ListNode listNode : result) {
            System.out.println(listNode.show());
        }
    }

}