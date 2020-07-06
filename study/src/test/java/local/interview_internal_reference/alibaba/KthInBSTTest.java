package local.interview_internal_reference.alibaba;

import local.interview_internal_reference.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/6 16:58
 */
public class KthInBSTTest {

    @Test
    public void testKth() {
        TreeNode root = new TreeNode(3,
                new TreeNode(2,
                        new TreeNode(1),
                        null),
                new TreeNode(5,
                        new TreeNode(4),
                        new TreeNode(6)));
        assertEquals(new KthInBST().kth(root, 2), 2);
        assertEquals(new KthInBST().kth(root, 1), 1);
        assertEquals(new KthInBST().kth(root, 5), 5);
        assertEquals(new KthInBST().kth(root, 7), -1);
    }
}