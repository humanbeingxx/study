package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class SeeNodeUpToDownTest {

    @Test
    public void testCanSee1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(7),
                                null),
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        new TreeNode(6,
                                new TreeNode(8,
                                        new TreeNode(9,
                                                new TreeNode(10,
                                                        new TreeNode(11,
                                                                new TreeNode(12,
                                                                        new TreeNode(13)))))))));
        List<TreeNode> result = new SeeNodeUpToDown().canSee(root);
        System.out.println(result.stream().map(e->e.val).collect(Collectors.toList()));
    }
}