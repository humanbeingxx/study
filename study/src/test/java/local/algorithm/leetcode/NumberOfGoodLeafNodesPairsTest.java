package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberOfGoodLeafNodesPairsTest {

    @Test
    public void testCountPairs() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4)),
                new TreeNode(3));
        int result = new NumberOfGoodLeafNodesPairs().countPairs(root, 3);
        assertEquals(result, 1);
    }
}