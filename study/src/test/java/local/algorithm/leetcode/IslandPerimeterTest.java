package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class IslandPerimeterTest {

    @Test
    public void testIslandPerimeter() {
        int result = new IslandPerimeter().islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        assertEquals(result, 16);
    }
}