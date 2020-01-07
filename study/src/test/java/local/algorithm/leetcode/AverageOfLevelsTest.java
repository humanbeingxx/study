package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class AverageOfLevelsTest {

    @Test
    public void testAverageOfLevels() {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        List<Double> result = new AverageOfLevels().averageOfLevels(root);
        System.out.println(result);
    }
}