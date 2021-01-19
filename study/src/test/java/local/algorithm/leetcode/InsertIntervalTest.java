package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class InsertIntervalTest {

    @Test
    public void testInsert1() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}, {5, 7}, {9, 11}, {13, 15}
        }, new int[]{6, 9});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert2() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}, {5, 7}, {9, 11}, {13, 15}
        }, new int[]{4, 9});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert3() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}, {5, 7}, {9, 11}, {13, 15}
        }, new int[]{6, 8});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert4() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}, {5, 7}, {9, 11}, {13, 15}
        }, new int[]{8,8});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert5() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}, {5, 7}, {9, 11}, {13, 15}
        }, new int[]{0, 20});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert6() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}, {5, 7}, {9, 11}, {13, 15}
        }, new int[]{3, 20});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert7() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}, {5, 7}, {9, 11}, {13, 15}
        }, new int[]{0, 14});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert8() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}
        }, new int[]{2,2});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert9() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}
        }, new int[]{1,4});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testInsert10() {
        int[][] result = new InsertInterval().insert(new int[][]{
                {1, 3}
        }, new int[]{0,2});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}