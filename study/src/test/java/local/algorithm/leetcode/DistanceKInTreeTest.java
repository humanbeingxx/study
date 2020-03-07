package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class DistanceKInTreeTest {

    TreeNode target = new TreeNode(5,
            new TreeNode(6),
            new TreeNode(2,
                    new TreeNode(7),
                    new TreeNode(4)));

    TreeNode root = new TreeNode(3,
            target,
            new TreeNode(1,
                    new TreeNode(0),
                    new TreeNode(8)));;

    @Test
    public void testDistanceK() {
        List<Integer> result = new DistanceKInTree().distanceK(root, target, 2);
        System.out.println(result);
    }

    @Test
    public void testToGraph() {
        Map<Integer, List<Integer>> graph = new DistanceKInTree().toGraph(root);
        System.out.println(graph);
    }
}