package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

public class FindMinHeightTreesTest {

    @Test
    public void testFindMinHeightTrees1() {
        List<Integer> result = new FindMinHeightTrees().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        System.out.println(result);
    }

    @Test
    public void testFindMinHeightTrees2() {
        List<Integer> result = new FindMinHeightTrees().findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        System.out.println(result);
    }

    @Test
    public void testFindMinHeightTrees3() {
        List<Integer> result = new FindMinHeightTrees().findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}});
        System.out.println(result);
    }

    @Test
    public void testFindMinHeightTrees4() {
        List<Integer> result = new FindMinHeightTrees().findMinHeightTrees(1, new int[][]{});
        System.out.println(result);
    }
}