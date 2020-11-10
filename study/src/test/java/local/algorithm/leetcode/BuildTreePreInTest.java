package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-24
 **/
public class BuildTreePreInTest {

    @Test
    public void testBuildTree1() {
        TreeNode root = new BuildTreePreIn().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
    }

    @Test
    public void testBuildTree2() {
        TreeNode root = new BuildTreePreIn().buildTree(new int[]{1,2}, new int[]{2,1});
        System.out.println(root);
    }
}