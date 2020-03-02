package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class GameOfLifeTest {

    @Test
    public void testGameOfLife() {
        int[][] data = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new GameOfLife().gameOfLife(data);
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
    }
}