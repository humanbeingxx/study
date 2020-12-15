package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MineSweepTest {

    @Test
    public void testUpdateBoard1() {
        char[][] result = new MineSweep().updateBoard(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        }, new int[]{3, 0});
        System.out.println(new MineSweep().display(result));
    }

    @Test
    public void testUpdateBoard2() {
        char[][] result = new MineSweep().updateBoard(new char[][]{
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        }, new int[]{1, 2});
        System.out.println(new MineSweep().display(result));
    }

}