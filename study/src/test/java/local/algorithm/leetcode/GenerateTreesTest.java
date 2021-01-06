package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-11
 **/
public class GenerateTreesTest {

    @Test
    public void testGenerateTrees3() {
        List<TreeNode> result = new GenerateTrees().generateTrees(3);
        System.out.println(result);
    }

    @Test
    public void testGenerateTrees4() {
        List<TreeNode> result = new GenerateTrees().generateTrees(4);
        System.out.println(result);
    }
}