package local.algorithm.leetcode;

import org.testng.annotations.Test;

import local.algorithm.leetcode.common.TreeNode;
import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/28 15:42
 */
public class BuildTreePreIn2Test {

    @Test
    public void testBuildTree1() {
        TreeNode root = new BuildTreePreIn2().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
    }

    @Test
    public void testBuildTree2() {
        TreeNode root = new BuildTreePreIn2().buildTree(new int[]{1,2}, new int[]{2,1});
        System.out.println(root);
    }
}