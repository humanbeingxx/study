package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BalanceBSTTest {

    @Test
    public void testBalanceBST() {
        TreeNode root = new TreeNode(6,
                new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(3,
                                        new TreeNode(2,
                                                new TreeNode(1)
                                                , null),
                                        null),
                                null),
                        null),
                null);
        TreeNode balanceBST = new BalanceBST().balanceBST(root);
        System.out.println(balanceBST);
    }
}