package local.algorithm.leetcode.lcof;

import local.algorithm.leetcode.BuildTreePreIn;
import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class BuildTreePreMidTest {

    @Test
    public void testBuildTree() {
        TreeNode root = new BuildTreePreMid().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(root);
    }


    @Test
    public void testBuildTree2() {
        TreeNode root = new BuildTreePreMid().buildTree(new int[]{1,2}, new int[]{2,1});
        System.out.println(root);
    }
}