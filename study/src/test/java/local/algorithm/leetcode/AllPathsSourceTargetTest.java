package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class AllPathsSourceTargetTest {

    @Test
    public void testAllPathsSourceTarget1() {
        List<List<Integer>> result = new AllPathsSourceTarget().allPathsSourceTarget(
                new int[][]{{1, 2}, {3}, {3}, {}}
        );
        System.out.println(result);
    }

    @Test
    public void testAllPathsSourceTarget2() {
        List<List<Integer>> result = new AllPathsSourceTarget().allPathsSourceTarget(
                new int[][]{{1}, {2}, {3}, {4}, {5}}
        );
        System.out.println(result);
    }
}