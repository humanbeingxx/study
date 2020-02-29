package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class RotateSquareTest {

    @Test
    public void testRotate1() {
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new RotateSquare().rotate(data);
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
    }

    @Test
    public void testRotate2() {
        int[][] data = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new RotateSquare().rotate(data);
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
    }

    @Test
    public void testRotate3() {
        int[][] data = {
                {2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };
        new RotateSquare().rotate(data);
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }

        // [4,33,13,32,12,2]
        // [24,1,14,33,27,29]
        // [1,20,32,32,9,20]
        // [6,7,27,2,25,26]
        // [32,21,22,28,13,16]
        // [34,7,26,14,21,28]
    }
}