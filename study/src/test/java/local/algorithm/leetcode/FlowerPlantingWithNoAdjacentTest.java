package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class FlowerPlantingWithNoAdjacentTest {

    @Test
    public void testGardenNoAdj1() {
        int[] result = new FlowerPlantingWithNoAdjacent().gardenNoAdj(3,
                new int[][]{{1, 2}, {2, 3}, {3, 1}});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testGardenNoAdj2() {
        int[] result = new FlowerPlantingWithNoAdjacent().gardenNoAdj(4,
                new int[][]{{1, 2}, {4, 3}});
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testGardenNoAdj3() {
        int[] result = new FlowerPlantingWithNoAdjacent().gardenNoAdj(4,
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}});
        System.out.println(Arrays.toString(result));
    }
}