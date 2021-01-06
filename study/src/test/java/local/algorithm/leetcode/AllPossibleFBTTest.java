package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class AllPossibleFBTTest {

    @Test
    public void testAllPossibleFBT5() {
        List<TreeNode> result = new AllPossibleFBT().allPossibleFBT(5);
        assertEquals(result.size(), 2);
    }

    @Test
    public void testAllPossibleFBT2() {
        List<TreeNode> result = new AllPossibleFBT().allPossibleFBT(2);
        assertEquals(result.size(), 0);
    }

    @Test
    public void testAllPossibleFBT7() {
        List<TreeNode> result = new AllPossibleFBT().allPossibleFBT(7);
        assertEquals(result.size(), 5);
        List<List<String>> show = result.stream()
                .map(e -> e.levelOrder().stream().map(String::valueOf).collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(show);
    }

    @Test
    public void testAllPossibleFBT9() {
        List<TreeNode> result = new AllPossibleFBT().allPossibleFBT(9);
        assertEquals(result.size(), 14);
        List<List<String>> show = result.stream()
                .map(e -> e.levelOrder().stream().map(String::valueOf).collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(show);
    }
}