package local.interview_internal_reference.byhunter;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

public class PrintTreeLeftRightTest {

    @Test
    public void testPrint() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8)
                                , new TreeNode(9)),
                        new TreeNode(5,
                                null,
                                new TreeNode(11))),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12),
                                null),
                        new TreeNode(7)));
        List<Integer> result = new PrintTreeLeftRight().print(root);
        System.out.println(result);
    }
}