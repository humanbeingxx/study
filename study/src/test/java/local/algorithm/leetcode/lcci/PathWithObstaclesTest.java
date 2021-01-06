package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import java.util.List;

public class PathWithObstaclesTest {

    @Test
    public void testPathWithObstacles1() {
        List<List<Integer>> result = new PathWithObstacles().pathWithObstacles(new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {1, 0, 0}
        });
        System.out.println(result);
    }

    @Test
    public void testPathWithObstacles2() {
        List<List<Integer>> result = new PathWithObstacles().pathWithObstacles(new int[][]{
                {1}
        });
        System.out.println(result);
    }
}