package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class MovesToMakeZigzagTest {

    @Test
    public void testMovesToMakeZigzag1() {
        int result = new MovesToMakeZigzag().movesToMakeZigzag(new int[]{1, 1});
        assertEquals(result, 1);
    }

    @Test
    public void testMovesToMakeZigzag2() {
        int result = new MovesToMakeZigzag().movesToMakeZigzag(new int[]{9, 6, 1, 6, 2});
        assertEquals(result, 4);
    }

    @Test
    public void testMovesToMakeZigzag3() {
        int result = new MovesToMakeZigzag().movesToMakeZigzag(new int[]{
                14, 6, 26, 38, 0, 32, 48, 18, 49, 10, 8, 42, 19, 27, 24, 44, 48, 41, 9, 4, 16, 42, 33, 24, 22, 23, 33, 26, 20, 24, 12, 7, 7, 44, 4, 19, 22, 12, 6, 38, 19, 39, 6, 7, 36, 9, 24, 31, 14, 2, 27, 49, 38, 48, 30, 40, 47, 29, 43, 32, 34, 44, 37, 37, 25, 0, 30, 21, 1, 45, 41, 37, 23, 34, 35, 34, 16, 38, 9, 17, 39, 0, 28, 18, 36, 20, 28, 40, 41, 39, 12, 12, 14, 35, 39, 47, 35, 6, 20, 4
        });
        assertEquals(result, 510);
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(data));
    }
}